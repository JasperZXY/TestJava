package com.jasper.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		for(int i=1; i<10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=1; i<10; i++) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + i + " of task " + task);
					}
				}
			});
		}
		threadPool.shutdown();
	}

}
