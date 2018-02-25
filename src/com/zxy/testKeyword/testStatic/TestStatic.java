package com.zxy.testKeyword.testStatic;

public class TestStatic {
	static {
		x = 5;
	}
	static int x, y;
	
	public static void main(String[] args) {
		x--;
		System.out.println(x);
		m();
		System.out.println(x + " " + y);
		System.out.println(x + y++ + x);
		x = 0;
		for(int i=0; i<100; i++) {
			x = x++;
		}
		System.out.println(x);
		x = 0;
		x = x++ + ++x;
		System.out.println(x);
	}
	
	public static void m() {
		x = 1;
		y = x++ + 1;
		System.out.println("y=" + y);
		x = 1;
		y = x++ + --x;
		System.out.println("y=" + y);
		x = 1;
		y = x-- + ++x;
		System.out.println("y=" + y);
		x = 1;
		y = --x + x++;
		System.out.println("y=" + y);
	}

}
