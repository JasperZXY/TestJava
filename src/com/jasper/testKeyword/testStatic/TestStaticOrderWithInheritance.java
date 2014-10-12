package com.jasper.testKeyword.testStatic;

/**
 * 有继承关系存在时，static语句的执行顺序
 * @author Jasper
 */
public class TestStaticOrderWithInheritance {
	public static void main(String[] args) {
		System.out.println("main start...");
		new B();
		System.out.println("main end...");
	}
}

class A {
	static {
		System.out.println("静态初始化语句块1");
	}
	public static int m1 = m1("m1 A");
	public int m2 = m2();
	static {
		System.out.println("静态初始化语句块2");
	}
	public A() {
		System.out.println("构造方法 A");
	}
	public static int m1(String msg) {
		System.out.println(msg);
		return 100;
	}
	public int m2() {
		System.out.println("普通方法m2");
		return 100;
	}
}

class B extends A {
	public static final int b = m1("m1 B");
	public B() {
		System.out.println("构造方法 B");
	}
	public int c = mb();
	private int mb() {
		System.out.println("普通方法mb");
		return 1;
	}
}
