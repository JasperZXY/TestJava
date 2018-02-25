package com.zxy.JDK8.util;

import java.util.function.Consumer;

/**
 * Consumer<T> - T作为输入，执行某种动作但没有返回值
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> hello = (name) -> System.out.println("Hello, " + name);
        hello.accept("zxy");

        Consumer<String> bye = (name) -> System.out.println("Bye, " + name);
        hello.andThen(bye).accept("zxy");
    }
}
