package com.jasper.testThread.testMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 注：wait()跟notify()是Object中的方法
 * <br/>
 *
 * 为什么wait, notify 和 notifyAll这些方法不在thread类里面？<br/>
 * JAVA提供的锁是对象级的而不是线程级的，每个对象都有锁，通过线程获得。
 * 如果线程需要等待某些锁那么调用对象中的wait()方法就有意义了。
 * 如果wait()方法定义在Thread类中，线程正在等待的是哪个锁就不明显了。
 * 简单的说，由于wait，notify和notifyAll都是锁级别的操作，
 * 所以把他们定义在Object类中因为锁属于对象。
 * <br/>
 *
 * 简单地打印1 2 3...
 * <p>
 * 多个任务一起执行，等所有任务都执行完了再返回数据。
 * 注意wait跟notify都需要加同步代码块，同时还要注意同步块用的对象应该跟wiat和notify保持一致。
 */
public class WaitNotify {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        AtomicInteger count = new AtomicInteger();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
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

        synchronized (count) {
            while (count.get() > 0) {
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
