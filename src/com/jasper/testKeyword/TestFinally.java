package com.jasper.testKeyword;

public class TestFinally {
	public static void main(String[] args) {
		Inner inner = getInner();
		System.out.println(inner);
		System.out.println(m());
	}
	
	public static Inner getInner() {
		Inner inner = new Inner();
		try {
			inner.a = 2;
			return inner;
		} finally {
			inner.a = 3;
		}
	}
	
	public static int m() {
		int a = 0;
		try {
			a = 1;
			return a;
		} catch (Exception e) {
			a = 2;
			return a;
		} finally {
			a = 3;
		}
	}
	
	static class Inner {
		int a;
		@Override
		public String toString() {
			return "a->" + a;
		}
	}

}

