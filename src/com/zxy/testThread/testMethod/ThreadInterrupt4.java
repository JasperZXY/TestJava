package com.zxy.testThread.testMethod;


import com.zxy.testThread.Utils;

/**
 * 由于ThreadInterrupt3 中用sleep来让程序停一下，但sleep会抛InterruptedException异常，
 * 导致中断状态重置，所以这个例子改用CPU空转的形式进行模拟
 *
 * @author zxy
 */
public class ThreadInterrupt4 implements Runnable {
	@Override
	public void run() {
		System.out.println("执行run()方法");

		for (int i=0; i<150; i++) {
			Utils.idle(11);

			// 处理业务逻辑，这里的逻辑简单，就打印一行
			if (!Thread.currentThread().isInterrupted()) {
				System.out.println(i);
			}
		}

		// 最后的语句
		if (!Thread.currentThread().isInterrupted()) {
			System.out.println("=====run end=====");
		}
	}

	public static void main(String []args) {
		Thread thread = new Thread(new ThreadInterrupt4());
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
