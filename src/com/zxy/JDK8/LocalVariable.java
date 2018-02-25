package com.zxy.JDK8;

/**
 * <strong>访问局部变量</strong><br/>
 * 可以直接在lambda表达式中访问外层的局部变量。
 * lambda表达式中变量默认隐性的具有final的语义。
 * 
 * @author Jasper
 *
 */
public class LocalVariable {
	public static void main(String[] args) {
		int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
		System.out.println(stringConverter.convert(2));
//		num = 10;  //这里num不能被修改，隐性的具有final的语义
	}
	
}
