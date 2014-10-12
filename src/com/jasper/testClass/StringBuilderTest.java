package com.jasper.testClass;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("012345");
		sBuilder.delete(sBuilder.length()-1, sBuilder.length());
		System.out.println(sBuilder.toString());
		int a = 1;
		int b = 2;
		sBuilder.append(a + b);
		System.out.println(sBuilder.toString());
	}
}
