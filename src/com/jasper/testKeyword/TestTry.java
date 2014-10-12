package com.jasper.testKeyword;

public class TestTry {
	public static void main(String[] args) {
		System.out.println(m());
//		new TestTry().fun(1);
	}

	public static int m() {
		int x = 0;
		try {
//			throw new NullPointerException();
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}
	}
	
	public void fun(final int c) {
		final int a[] = {1};
		final int b;
		
		
		class A {
			public void m() {
				a[0] = 2;
				if(c > 4) {
				}
			}
		}
		
		new A().m();
		System.out.println(a[0]);
	}
	
}
