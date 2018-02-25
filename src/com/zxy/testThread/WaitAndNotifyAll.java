package com.zxy.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitAndNotifyAll {
	public static void main(String []args) {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
}

/**
 * 汽车类，模仿一个上蜡，抛光的过程
 * 说明：一定要在上蜡完才可以进行抛光
 * @author Jasper
 */
class Car {
	/**是否已经上蜡了*/
	private boolean waxOn = false;
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}
	
	/**
	 * 等着上蜡
	 */
	public synchronized void waitForWaxing() {
		try {
			while(waxOn == false) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 等着抛光
	 */
	public synchronized void waitForBuffing() {
		try {
			while(waxOn == true) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class WaxOn implements Runnable {
	private Car car;
	public WaxOn(Car car) {
		this.car = car;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(100);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending Wax on task...");
	}
}

class WaxOff implements Runnable {
	private Car car;
	public WaxOff(Car car) {
		this.car = car;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Buffed");
				TimeUnit.MILLISECONDS.sleep(100);
				car.buffed();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending wax off task");
	}
}








