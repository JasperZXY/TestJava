package com.jasper.testThread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(4,
				new MyThreadFactory("test-thread-pool-"));
		for (int i = 1; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 1; i < 10; i++) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ " is looping of " + i + " of task " + task);
					}
				}
			});
		}
		threadPool.shutdown();

		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable() {// 每隔一段时间就触发异常
					@Override
					public void run() {
						throw new RuntimeException();
						// System.out.println("================");
					}
				}, 1000, 5000, TimeUnit.MILLISECONDS);
		exec.scheduleAtFixedRate(new Runnable() {// 每隔一段时间打印系统时间，证明两者是互不影响的
					@Override
					public void run() {
						System.out.println(System.nanoTime());
					}
				}, 1000, 2000, TimeUnit.MILLISECONDS);

		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class MyThreadFactory implements ThreadFactory {
		private String name;
		private AtomicInteger count = new AtomicInteger(-1);

		public MyThreadFactory(String name) {
			this.name = name;
		}

		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, name + count.incrementAndGet());
		}

	}

}
