package com.jasper.testThread.testMethod;


/**
 * 模拟一下线程的中断
 * @author Jasper
 */
public class ThreadInterrupt implements Runnable {
	@Override
	public void run() {
		System.out.println("执行run()方法");
		try {
			Thread.sleep(2000);
			System.out.println("线程完成休眠");
		} catch (InterruptedException e) {
			System.out.println("线程被中断");
		}
	}
	
	public static void main(String []args) {
		ThreadInterrupt ti = new ThreadInterrupt();
		Thread thread = new Thread(ti);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("main方法中线程休眠被中断");
		}
		thread.interrupt();   //中断线程
	}

}
