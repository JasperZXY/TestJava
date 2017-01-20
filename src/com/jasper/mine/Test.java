package com.jasper.mine;

public class Test {

	public static void main(String[] args) {
		System.out.println(System.getSecurityManager());
	}

}

class TestSuperClass {
	static {
		System.out.println("super class");
	}
	public static int value = 2;
}

class TestSubClass extends TestSuperClass {
	static {
		System.out.println("sub class");
	}
}
