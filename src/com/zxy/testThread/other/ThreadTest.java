package com.zxy.testThread.other;

public class ThreadTest implements Runnable {

	public static int a = 0;

	public synchronized void inc() {
		a++;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			inc();
		}
	}

	public static void main(String[] args) throws Exception {

		Runnable r = new ThreadTest();
		Thread t1 = new Thread(r);
		t1.start();

		t1.join();
		System.out.println(a);
	}
}