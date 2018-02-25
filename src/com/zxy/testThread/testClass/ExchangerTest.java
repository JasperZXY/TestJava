package com.zxy.testThread.testClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger可以在两个线程之间交换数据，只能是2个线程，他不支持更多的线程之间互换数据
 */
public class ExchangerTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable() {
			@Override
			public void run() {
				try {

					String data1 = "10元";
					System.out.println("线程" + Thread.currentThread().getName()
							+ "正在把数据" + data1 + "换出去");
					Thread.sleep((long) (Math.random() * 3000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName()
							+ "换回的数据为" + data2);
				} catch (Exception e) {

				}
			}
		});
		service.execute(new Runnable() {
			@Override
			public void run() {
				try {

					String data1 = "盒饭";
					System.out.println("线程" + Thread.currentThread().getName()
							+ "正在把数据" + data1 + "换出去");
					Thread.sleep((long) (Math.random() * 3000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName()
							+ "换回的数据为" + data2);
				} catch (Exception e) {

				}
			}
		});
		service.shutdown();
	}
}
