package com.jasper.testThread.testMethod;


/**
 * 对线程的优先级进行设置
 * @author Jasper
 */
public class ThreadPriority implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("当前线程->" + Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String []args) {
		Thread t1 = new Thread(new ThreadPriority(), "A");
		Thread t2 = new Thread(new ThreadPriority(), "B");
		Thread t3 = new Thread(new ThreadPriority(), "C");
		t1.setPriority(8);
		t2.setPriority(2);
		t3.setPriority(4);
		t1.start();
		t2.start();
		t3.start();
	}

}
