package com.zxy.testThread.testMethod;


import com.zxy.testThread.Utils;

/**
 * 测试中断处于死锁状态的两个线程。
 *
 * m1() m2()的分别让对方获取到一个锁后进行了sleep，
 * main在两个方法都获取到一个锁后，分别等待获取另一个锁时，让两个线程中断，
 * 结果发现中断是不起效果的。
 *
 * 结论：没法中断处于死锁状态的两个线程。
 *
 * @author zxy
 */
public class ThreadInterrupt5 {

	private static Object lockObj1 = new Object();
	private static Object lockObj2 = new Object();

	public static void main(String []args) {
		Thread t1 = new Thread(() -> m1());
		Thread t2 = new Thread(() -> m2());

		t1.start();
		t2.start();

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.interrupt();
		t2.interrupt();

		System.out.println("main t1.isInterrupted:" + t1.isInterrupted());
		System.out.println("main t2.isInterrupted:" + t2.isInterrupted());
		System.out.println("=====main end=====");
	}

	public static void m1() {
		synchronized (lockObj1) {
			Utils.idle(1000);

			synchronized (lockObj2) {
				System.out.println("=====m1======");
			}

			System.out.println("=====m1 end======");
		}
	}

	public static void m2() {
		synchronized (lockObj2) {
			Utils.idle(1000);

			synchronized (lockObj1) {
				System.out.println("=====m2======");
			}

			System.out.println("=====m2 end======");
		}
	}

}
