package com.zxy.testKeyword.testStatic;

/**
 * static语句,构造代码块,构造方法的执行顺序
 * @author Jasper
 *
 * 输出结果
 * 静态初始化语句块1
 * 静态方法m1
 * 静态初始化语句块2
 * main start...
 * 普通方法m2
 * 构造方法
 * main end...
 */
public class TestStaticOrder {
	static {
		System.out.println("静态初始化语句块1");
	}
	public static int m1 = m1();
	public int m2 = m2();
	static {
		System.out.println("静态初始化语句块2");
	}

	public TestStaticOrder() {
		System.out.println("构造方法");
	}

	public static int m1() {
		System.out.println("静态方法m1");
		return 100;
	}
	public int m2() {
		System.out.println("普通方法m2");
		return 100;
	}

	public static void main(String[] args) {
		System.out.println("main start...");
		new TestStaticOrder();
		System.out.println("main end...");
	}
}
