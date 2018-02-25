package com.zxy.testThread;

/**
 * 一个简单继承Thread父类来实现的一个简单的多线程
 * 
 * @author Jasper
 */
public class SimpleThread extends Thread {
	public SimpleThread() {
	}

	public SimpleThread(String name) {
		super(name);
	}

	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	public static void main(String[] args) {
//		 SimpleThread s1 = new SimpleThread("A");
//		 SimpleThread s2 = new SimpleThread("B");
		SimpleThread thread = new SimpleThread("---");
		Thread s1 = new Thread(thread, "A");
		Thread s2 = new Thread(thread, "B");
		s1.start();
		s2.start();
	}

}
