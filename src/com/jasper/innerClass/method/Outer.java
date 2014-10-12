package com.jasper.innerClass.method;

/**
 * 方法内部类
 * @author Jasper
 */
public class Outer {
	public int m(final int value) {
		final int a = 2;
		class Inner {
			public int getValue() {
				return value * a + 1;
			}
		}
		return new Inner().getValue();
	}
	public static void main(String[] args) {
		System.out.println(new Outer().m(2));
	}

}
