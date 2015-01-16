package com.jasper.testThread;

/**
 * 测试在jvm关闭前，先做一些事情
 * @author Jasper
 */
public class TestHook {
	public static void main(String[] args) {
		System.out.println("main start");
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<100; i++) {
					System.out.println("thread:" + i);
					//这里本意是要程序停止的
					if (i == 10) {
						System.exit(0);
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		System.out.println("main end");
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<10; i++) {
					System.out.println("hook:" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}));
	}
}
