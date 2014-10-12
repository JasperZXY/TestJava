package com.jasper.testClass;

public class PrivateOverride {
	static class A {
		private void m() {
			System.out.println("A");
		}
	}
	static class B extends A {
		public void m() {
			System.out.println("B");
		}
	}
	public static void main(String[] args) {
		A a = new B();
		a.m();
		B b = new B();
		b.m();
	}
}
