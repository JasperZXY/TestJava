package com.zxy.testThread.testMethod;


/**
 * InterruptedException 在for循环内部进行处理，无法中断
 * @author zxy
 */
public class ThreadInterrupt1 implements Runnable {
	@Override
	public void run() {
		System.out.println("执行run()方法");

        for (int i=0; i<150; i++) {
            try {
                Thread.currentThread().sleep(11);
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println("线程被中断");
            }
        }

		System.out.println("=====run end=====");
	}

	public static void main(String []args) {
		Thread thread = new Thread(new ThreadInterrupt1());
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
