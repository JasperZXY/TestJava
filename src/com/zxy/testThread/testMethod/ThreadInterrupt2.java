package com.zxy.testThread.testMethod;


/**
 * InterruptedException 在for循环外层进行处理，程序还是没办法真正中断
 * @author zxy
 */
public class ThreadInterrupt2 implements Runnable {
	@Override
	public void run() {
		System.out.println("执行run()方法");

		try {
			for (int i=0; i<150; i++) {
				Thread.currentThread().sleep(11);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			System.out.println("线程被中断");
			System.out.println("run isInterrupted:" + Thread.currentThread().isInterrupted());
		}

		System.out.println("=====run end=====");
	}

	public static void main(String []args) {
		Thread thread = new Thread(new ThreadInterrupt2());
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("main方法中线程休眠被中断");
		}
		thread.interrupt();
		System.out.println("main isInterrupted:" + thread.isInterrupted());
	}

}
