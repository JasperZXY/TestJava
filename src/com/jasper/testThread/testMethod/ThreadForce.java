package com.jasper.testThread.testMethod;

/**
 * 强制子线程的执行
 * @author Jasper
 */
public class ThreadForce implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("子线程" + Thread.currentThread() + i);
		}
	}
	
	public static void main(String []args) {
		ThreadForce tf = new ThreadForce();
		Thread thread = new Thread(tf, "线程");
		thread.start();
		for(int i=0; i<50;  i++) {
			if(i > 10) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main线程" + i);
		}
	}

}
