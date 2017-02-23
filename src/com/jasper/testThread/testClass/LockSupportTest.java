package com.jasper.testThread.testClass;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Jasper (zhongxianyao)
 */
public class LockSupportTest {
    public static void main(String[] args) {
        final Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" wakup others");
            LockSupport.unpark(mainThread);
        });

        System.out.println(Thread.currentThread().getName()+" start thread");
        thread.start();

        System.out.println(Thread.currentThread().getName()+" block");
        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(Thread.currentThread().getName()+" continue");
    }
}
