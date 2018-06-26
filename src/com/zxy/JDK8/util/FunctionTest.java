package com.zxy.JDK8.util;

import java.util.Arrays;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Function<T, R> -T作为输入，返回的R作为输出
 * IntFunction<R> 入参是int值，返回的R作为输出，其他的还有DoubleFunction、LongFunction
 * ToIntFunction<T>  -T作为输入，返回的值是int类型
 * BiFunction<T, U, R> 两个入参T跟U，R作为返回
 * BinaryOperator<T> 继承BiFunction，也是两个入参，一个返回，但是三个的类似都是一样的
 */
public class FunctionTest {
    public static void main(String[] args) {
        /**
         * Function 接口有一个参数并且返回一个结果，
         * 并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
         */
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));     // "123"
        System.out.println(backToString.apply("123").getClass());
        System.out.println(toInteger.apply("123").getClass());

        // compose 函数先执行参数，然后执行调用者，而 andThen 先执行调用者，然后再执行参数。
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        System.out.println(times2.compose(squared).apply(3));
        System.out.println(times2.andThen(squared).apply(3));

        // identity 返回入参自己
        Map<String, Integer> strLengthMap = Arrays.asList("a", "bb", "ccc").stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(strLengthMap);

        // IntFunction 特殊的Function，入参只能接收int值
        IntFunction<String> intToStr = Integer::toHexString;
        System.out.println(intToStr.apply(31));

        // ToIntFunction
        ToIntFunction<String> toInt = Integer::valueOf;
        System.out.println(toInt.applyAsInt("12") + 3);     // 15

        // BiFunction
        BiFunction<Integer, Integer, String> toAdd = (first, second) -> first.toString() + second.toString();
        System.out.println(toAdd.apply(13, 14));    // 1314

        // BinaryOperator
        BinaryOperator<Integer> operator = (first, second) -> first * 2 + second;
        System.out.println(operator.apply(3, 5));
    }

}

