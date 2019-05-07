package com.zxy.testThread.testMethod;


/**
 * interrupt()方法是中断线程，会设置该线程的中断状态位为true，
 * 但具体线程是继续执行还是中断结束，由程序自行处理，见下面run()方法最后
 * 一条语句的运行，运行前先`if (!Thread.currentThread().isInterrupted())`
 * <br/>
 * 抛出InterruptedException异常后，interrupt的标志位会被置为false，
 * 所以运行需要，一般需要重新设置中断标志`Thread.currentThread().interrupt()`
 * @author zxy
 */
public class ThreadInterrupt3 implements Runnable {
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

			Thread.currentThread().interrupt();	// 重新设置
		}

		// 最后的语句
		if (!Thread.currentThread().isInterrupted()) {
			System.out.println("=====run end=====");
		}
	}

	public static void main(String []args) {
		Thread thread = new Thread(new ThreadInterrupt3());
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
