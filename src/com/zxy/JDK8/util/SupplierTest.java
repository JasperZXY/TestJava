package com.zxy.JDK8.util;

import java.util.function.Supplier;

/**
 * Supplier<T> - 没有任何输入，返回T
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Integer> dice = () -> (int)(Math.random() * 6) + 1;
        System.out.println(dice.get() + " " + dice.get() + " " + dice.get());
    }
}
