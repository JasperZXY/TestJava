package com.jasper.testThread.testClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest2 {
	public static void main(String[] args) {
		int count = 3;
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		ExecutorService threadPool = Executors.newFixedThreadPool(count);
		for (int i=0; i<count; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "start");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "end");
					countDownLatch.countDown();
				}
			});
		}
		threadPool.shutdown();
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
