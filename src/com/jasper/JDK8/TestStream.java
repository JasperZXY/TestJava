package com.jasper.JDK8;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
 * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，
 * 而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
 * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。
 * Stream的操作可以串行执行或者并行执行。
 *
 * @author Jasper
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("dddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bb1");
        stringCollection.add("aa1");
        stringCollection.add("bbb3");
        stringCollection.add("c");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        System.out.println("data:" + stringCollection);

        // Filter 过滤
        System.out.println("=====Filter 过滤=====");
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // Sort 排序
        System.out.println("=====Sort 排序=====");
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("data:" + stringCollection);  //排序没变

        // Map 映射
        System.out.println("=====Map 映射=====");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // Match 匹配
        System.out.println("=====Match 匹配=====");
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true
        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false
        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true

        // Count 计数
        System.out.println("=====Count 计数=====");
        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);    // 3

        // collect
        System.out.println("=====collect=====");
        Map<Integer, Set<String>> collectResult = stringCollection
                .stream()
                .collect(Collectors.toMap(String::length, Collections::singleton, (set1, set2) -> {
                    Set<String> set = new HashSet<>(set1);
                    set.addAll(set2);
                    return set;
                }));
        System.out.println(collectResult);

        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(Collectors.toList());
        System.out.println(numsWithoutNull);

        // groupBy
        System.out.println("=====groupBy=====");
        stringCollection.stream()
                .collect(Collectors.groupingBy(String::length))
                .forEach((length, list) -> System.out.println("长度为" + length + "的有" + list));
        Map<Integer, List<String>> groupByResult = stringCollection.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupByResult);
        Map<Integer, Set<String>> groupByResult2 = stringCollection.stream().collect(
                Collectors.groupingBy(String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.toSet()))
        );
        System.out.println("groupByResult2:" + groupByResult2);

        stringCollection.stream()
                .filter(s -> s.length() >= 1)
                .map(s -> Arrays.asList(s.substring(0, 1), s))
                .collect(Collectors.groupingBy(list -> list.get(0)))
                .forEach((start, list) -> {
                    System.out.print("以" + start + "开头的字符串：");
                    list.stream().forEach(data -> System.out.print(data.get(1) + ","));
                    System.out.println("");
                });

        // map and flatMap
        System.out.println("map and flatMap");
        List<String> words = Arrays.asList("ABC", "DF");
        Stream<Stream<Character>> result1 = words.stream().map(w -> characterStream(w));
        result1.forEach(stream -> System.out.println(Arrays.asList(stream.toArray())));
        Stream<Character> result2 = words.stream().flatMap(w -> characterStream(w));
        System.out.println("result2:" + Arrays.asList(result2.toArray()));

        // 并行Streams
        System.out.println("=====并行Streams=====");

        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 窜行排序
        Collections.shuffle(values);
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // 并行排序，慎用
        Collections.shuffle(values);
        long t2 = System.nanoTime();
        long count2 = values.parallelStream().sorted().count();
        System.out.println(count2);
        long t3 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis2));

        System.out.println("========性能测试========");
        Collections.shuffle(stringCollection);
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        for (int i = 0; i < 10000; i++) {
            long curTime1 = System.nanoTime();
            stringCollection
                    .stream()
                    .filter((s) -> s.startsWith("a"))
                    .forEach(System.out::println);
            long curTime2 = System.nanoTime();
            sum1 += (curTime2 - curTime1);

            for (int j = 0; j < stringCollection.size(); j++) {
                if (stringCollection.get(j).startsWith("a")) {
                    System.out.println(stringCollection.get(j));
                }
            }
            long curTime3 = System.nanoTime();
            sum2 += (curTime3 - curTime2);

            for (String s : stringCollection) {
                if (s.startsWith("a")) {
                    System.out.println(s);
                }
            }
            long curTime4 = System.nanoTime();
            sum3 += (curTime4 - curTime3);
        }

        /**
         * 10000次
         * sum1:60048658
         * sum2:53022839
         * sum3:54946902
         *
         * 1000000次
         * sum1:4949164190
         * sum2:4893336835
         * sum3:4924789351
         *
         * 结果：对于ArrayList，用for(i++)方式操作是最快的，用foreach次之，用stream()是最慢的
         *
         */
        System.out.println("========性能测试结果========");
        System.out.println("sum1:" + sum1);
        System.out.println("sum2:" + sum2);
        System.out.println("sum3:" + sum3);

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result.stream();
    }

}
