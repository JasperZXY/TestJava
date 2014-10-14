package com.jasper.testThread.testMethod;

import java.util.concurrent.TimeUnit;

/**
 * 线程的礼让
 * @author Jasper
 */
public class ThreadYield implements Runnable {
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("当前线程" + Thread.currentThread().getName() + " " + i);
//			if(i == 6) {
				System.out.println("当前线程" + Thread.currentThread().getName() + "线程礼让");
				Thread.currentThread().yield();
//				try {
//					TimeUnit.MILLISECONDS.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	public static void main(String []args) {
		for(int i=0; i<2; i++) {
			Thread thread = new Thread(new ThreadYield(), "Thread" + i);
			thread.setPriority(1 + i * 4);
			thread.start();
		}
//		new Thread(new ThreadYield(), "A").start();
//		new Thread(new ThreadYield(), "B").start();
//		new Thread(new ThreadYield(), "C").start();
//		new Thread(new ThreadYield(), "D").start();
	}

}
