package com.zxy.JDK8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "C", "D", "b");
//        List<String> names = new ArrayList<>();
        System.out.println(Thread.currentThread().getName());
        Collections.sort(names, (a, b) -> {
            System.out.println(Thread.currentThread().getName());
            return b.compareTo(a);
        });
        names.parallelStream().filter(w -> w.length() > 12).count();

        Integer[] values = {1, 2, 3, 4};
        Arrays.parallelPrefix(values, (x, y) -> x + y);
        System.out.println(Arrays.asList(values));

    }
}
