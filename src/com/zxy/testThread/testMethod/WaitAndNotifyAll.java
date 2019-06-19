package com.zxy.testThread.testMethod;

import com.zxy.testThread.Utils;


/**
 * 测试notifyAll
 */
public class WaitAndNotifyAll {

    public static void main(String[] args) {
        Object lockObj = new Object();

        int count = 10;
        for (int i=0; i<count; i++) {
            new Thread(() -> {
                synchronized (lockObj) {
                    System.out.println(Thread.currentThread().getName() + " start to wait");
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return; // 这里没有finally，直接return没有其他副作用
                    }
                    System.out.println(Thread.currentThread().getName() + " end to wait");
                }
            }, "Thread" + i).start();
        }

        Utils.idle(1000);

        synchronized (lockObj) {
            lockObj.notifyAll();
            System.out.println("main notifyAll");
        }
    }

}
