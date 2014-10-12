package com.jasper.testException;

public class Test {
	public static void main(String[] args) {
		int a = 0;
		try {
			System.out.println(a / a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
