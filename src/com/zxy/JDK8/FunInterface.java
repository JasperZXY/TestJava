package com.zxy.JDK8;

/**
 * <strong>函数式接口</strong><br/>
 * Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，
 * 通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，
 * 每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 * 
 * 需要使用注解@FunctionalInterface
 * @author Jasper
 *
 */
public class FunInterface {
	public static void main(String[] args) {
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted); // 123

	}
}
