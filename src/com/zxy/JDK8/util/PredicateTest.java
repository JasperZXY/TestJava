package com.zxy.JDK8.util;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Predicate<T> -T作为输入，返回的boolean值作为输出
 */
public class PredicateTest {

    public static void main(String[] args) {
        /*
         * Predicate 接口只有一个参数，返回boolean类型。
         * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
         */
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));           // true
        System.out.println(predicate.negate().test("foo"));  // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isNotEmpty.test("abc"));

        // and
        System.out.println("=====and=====");
        Predicate<String> predicateAnd1 = s -> s.length() > 3;
        Predicate<String> predicateAnd2 = s -> s.length() < 6;
        System.out.println(predicateAnd1.and(predicateAnd2).test("1234"));      // true
        System.out.println(predicateAnd1.and(predicateAnd2).test("12345678"));  // false

        System.out.println("=====or=====");
        Predicate<String> predicateOr1 = s -> s.length() < 3;
        Predicate<String> predicateOr2 = s -> s.length() > 6;
        System.out.println(predicateOr1.or(predicateOr2).test("12"));       // true
        System.out.println(predicateOr1.or(predicateOr2).test("12345"));    // false

        System.out.println("=====isEqual=====");
        String str1 = null;
        String str2 = null;
        System.out.println(Predicate.isEqual(str1).test(str2)); // true
        System.out.println(Objects.equals(str1, str2));
    }
}
