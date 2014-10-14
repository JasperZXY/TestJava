package com.jasper.testThread.testMethod;

public class ThreadJoin implements Runnable {

	public static int a = 0;

	public synchronized void inc() {
		a++;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			inc();
		}
	}

	public static void main(String[] args) throws Exception {

		Runnable r = new ThreadJoin();
		Thread t1 = new Thread(r);
		t1.start();

		//让t1执行完后再去获取a的值，这样才能获得到正确的值
		t1.join();
		System.out.println(a);
	}
}