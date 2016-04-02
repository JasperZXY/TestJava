package com.jasper.testThread.other;

class TestThreadMethod extends Thread {
	public static int shareVar = 0;

	public TestThreadMethod(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.println(" : " + i);
			 Thread.yield();
			/* （2）
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			} */
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		TestThreadMethod t1 = new TestThreadMethod("t1");
		TestThreadMethod t2 = new TestThreadMethod("t2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}