package com.zxy.testThread.testClass;

import java.util.Random;

/**
 * 这个程序是对ShareData的改进，用了Java API提供的类进行操作
 * 
 * @see ShareData
 * @author Jasper
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> localData = new ThreadLocal<Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println("main thread " + Thread.currentThread()
							+ " creates a data :" + data);
					localData.set(data);
					MyThreadData.getThreadInstance().setAge(data);
					MyThreadData.getThreadInstance().setName("name" + data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			System.out.println("A thread " + Thread.currentThread()
					+ " get data :" + localData.get() + " name->"
					+ MyThreadData.getThreadInstance().getName() + " age->"
					+ MyThreadData.getThreadInstance().getAge());
		}
	}

	static class B {
		public void get() {
			System.out.println("B thread " + Thread.currentThread()
					+ " get data :" + localData.get() + " name->"
					+ MyThreadData.getThreadInstance().getName() + " age->"
					+ MyThreadData.getThreadInstance().getAge());
		}
	}

}

class MyThreadData {

	private static ThreadLocal<MyThreadData> mThreadLocal = new ThreadLocal<MyThreadData>();

	private MyThreadData() {
	}

	public static MyThreadData getThreadInstance() {
		MyThreadData data = mThreadLocal.get();
		if (data == null) {
			data = new MyThreadData();
			mThreadLocal.set(data);
		}
		return data;
	}

	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
