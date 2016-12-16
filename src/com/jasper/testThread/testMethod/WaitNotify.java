package com.jasper.testThread.testMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单地打印1 2 3...
 *
 * 多个任务一起执行，等所有任务都执行完了再返回数据。
 * 注意wait跟notify都需要加同步代码块，同时还要注意同步块用的对象应该跟wiat和notify保持一致。
 */
public class WaitNotify {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        AtomicInteger count = new AtomicInteger();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i=0; i<10; i++) {
            count.incrementAndGet();
            final int num = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num + "\t" + Thread.currentThread().getName());
                    count.decrementAndGet();
                    synchronized (count) {
                        count.notify();
                    }
                }
            });
        }

        while (count.get() > 0) {
            synchronized (count) {
                System.out.println("wait start " + count.get());
                try {
                    count.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end");
            }
        }

        System.out.println("end " + (System.currentTimeMillis() - startTime));
        threadPool.shutdown();
    }
}
