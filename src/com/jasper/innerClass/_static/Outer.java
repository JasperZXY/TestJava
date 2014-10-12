package com.jasper.innerClass._static;

/**
 * 静态内部类
 * @author Jasper
 */
public class Outer {
	public static class Inner {
		public void m() {
			System.out.println("Inner m()");
		}
	}
	
	public static void main(String[] args) {
		new Inner().m();
	}
}
