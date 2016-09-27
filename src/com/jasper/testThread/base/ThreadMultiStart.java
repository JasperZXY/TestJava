package com.jasper.testThread.base;

import java.util.Date;

public class ThreadMultiStart implements Runnable {
    public static void main(String[] args) {
        ThreadMultiStart task = new ThreadMultiStart();
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();     // 多次调用会抛异常
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run start " + new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " run end   " + new Date());
    }
}
