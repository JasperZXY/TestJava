package com.zxy.testThread.threadVolatile;

public class TestVolatile5 extends Thread {
	// 非volatile标志
	private static boolean flag1 = false;
	// volatile标志
	private static volatile boolean flag2 = false;
	private int i = 0;
	@Override
	public void run() {
		//Object o = new Object();
		//synchronized (o) {
			/*
			 * 注释1
			 */
			while (!flag1) {
				i++;
				//System.out.println(i);
                                //注意 ： System.out.println(i);
				/*
				 * 注释2
				 */
				if (flag2) {
					System.out.println("==================over:" + i);
					break;
				}
			}
		//}
	}

	public static void main(String[] args) {
		TestVolatile5 t = new TestVolatile5();
		t.start();
		try {
			Thread.currentThread();
			Thread.sleep(10);
			System.out.println("=============================111111");
			// 先更改flag1
			TestVolatile5.flag1 = true;
			Thread.currentThread();
			/*
			 * 注释3
			 */
			Thread.sleep(1000);
			// 将flag2置为true，如果有机会进入if(flag2),则将退出循环
			System.out.println("=============================222222");
			TestVolatile5.flag2 = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}