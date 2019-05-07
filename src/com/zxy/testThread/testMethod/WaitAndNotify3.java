package com.zxy.testThread.testMethod;

import com.zxy.testThread.Utils;

/**
 * 测试wait()方法的中断效果
 */
public class WaitAndNotify3 {

    public static void main(String[] args) {

        Object lockObj = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lockObj) {
                System.out.println("start to wait");
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return; // 这里没有finally，直接return没有其他副作用
                }
                System.out.println("end to wait");
            }
        });

        thread.start();

        Utils.idle(500);
        thread.interrupt();

        System.out.println("main end");
    }
}
