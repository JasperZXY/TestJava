package com.jasper.testThread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器
 * @author Jasper
 */
public class ThreadTimer {
	public static void main(String[] args) {
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(2);
		timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            	System.out.println("AtFixedRate " + new Date());
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        }, 0, 1, TimeUnit.SECONDS);
		
		timer.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("WithFixedDelay " + new Date());
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
	}

}
