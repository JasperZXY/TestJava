package com.jasper.testThread.threadVolatile;

public class TestVolatile4 {
	private volatile int n1 = 0;// volatile
	private int n2 = 0;

	public static void main(String[] a) {
		new TestVolatile4().test();
		new TestVolatile4().test();
	}

	public void test() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				do {
				} while (n1 >= n2);
				System.out.println("n2>n1 " + n1 + " " + n2);
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (; n1 < 100000;) {
					++n1;
					++n2;
				}
				System.out.println("stoped");
			}
		};
		t1.start();
		t2.start();
	}
}