package com.jasper.testThread.testClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 由于要对变量进行共享，map储存固定线程中的数据
 * @see ThreadLocalTest
 * @author Jasper
 */
public class ShareData {
	private static Map<Thread, Integer> map = new HashMap<Thread, Integer>();
	
	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println("main thread " + Thread.currentThread() + " creates a data :" + data);
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			System.out.println("A thread " + Thread.currentThread() + " get data :" + map.get(Thread.currentThread()));
		}
	}
	
	static class B {
		public void get() {
			System.out.println("B thread " + Thread.currentThread() + " get data :" + map.get(Thread.currentThread()));
		}
	}
}

