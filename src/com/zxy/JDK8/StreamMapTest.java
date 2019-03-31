package com.zxy.JDK8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


/**
 * Created by zhongxianyao.
 */
public class StreamMapTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "22", "33", "4", "5");
        BinaryOperator<Set<String>> mergeFunction = (set1, set2) -> {
            Set<String> set = new MySet<>(set1);
            set.addAll(set2);
            System.out.println("set1:" + set1 + " set2:" + set2);
            return set;
        };
        /*
        运行结果
        newSet(T t)1
        newSet(T t)22
        newSet(T t)33
        MySet(Collection c)
        set1:[22] set2:[33]
        newSet(T t)4
        MySet(Collection c)
        set1:[1] set2:[4]
        newSet(T t)5
        MySet(Collection c)
        set1:[1, 4] set2:[5]

        居然是有多少个元素就调用多少次StreamMapTest::newSet
         */
        list.stream().collect(Collectors.toMap(String::length, StreamMapTest::newSet, mergeFunction));

        System.out.println("===============");

        /*
        下面几种情况都会抛错 java.lang.IllegalStateException: Duplicate key [22]
        也就是Collectors.toMap 默认情况下一个key对应一个value
         */
        // list.stream().collect(Collectors.toMap(String::length, StreamMapTest::newSet));
        // list.stream().collect(Collectors.toMap(String::length, StreamMapTest::newList));
    }

    public static <T> Set<T> newSet(T t) {
        System.out.println("newSet(T t)" + t);
        Set<T> set = new HashSet<>();
        set.add(t);
        return set;
    }

    public static <T> List<T> newList(T t) {
        System.out.println("newList(T t)" + t);
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    public static class MySet<V> extends HashSet<V> {

        public MySet() {
            super();
            System.out.println("MySet()");
        }


        public MySet(Collection c) {
            super(c);
            System.out.println("MySet(Collection c)");
        }


        public MySet(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
            System.out.println("MySet(int initialCapacity, float loadFactor)");
        }


        public MySet(int initialCapacity) {
            super(initialCapacity);
            System.out.println("MySet(int initialCapacity)");
        }
    }

}
