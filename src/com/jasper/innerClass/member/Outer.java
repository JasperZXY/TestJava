package com.jasper.innerClass.member;

/**
 * 成员内部类
 * @author Jasper
 */
public class Outer {
	public class Inner {
		public void m() {
			System.out.println("m()");
		}
	}
	
	public static void main(String[] args) {
		new Outer().new Inner().m();
		//new Inner().m();  //编译出错的
	}
}
