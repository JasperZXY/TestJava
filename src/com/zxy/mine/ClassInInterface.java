package com.zxy.mine;

public class ClassInInterface implements TheInterface {
	public void m() {
		new A().m();
	}
	public static void main(String[] args) {
		new A().m();
	}

}
interface TheInterface {
	public class A {
		public void m() {
			System.out.println("=====");
		}
	}
}
