package com.jasper.testThread.threadVolatile;

public class TestVolatile2 {
	public static int count = 0;

	public static void inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		count++;
	}

	public static void main(String[] args) {
		// 同时启动1000个线程，去进行i++计算，看看实际结果
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					TestVolatile2.inc();
				}
			}).start();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println("运行结果:Counter.count=" + TestVolatile2.count);
	}
}