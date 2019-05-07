package com.zxy.testThread.testMethod;

import com.zxy.testThread.Utils;

/**
 * 当方法wait()被执行后，锁自动被释放，但执行完notify()方法后，锁不会自动释放，
 * 必须执行完notify()方法所在的synchronized代码块后才释放。
 */
public class WaitAndNotify2 {


    public static void main(String[] args) {
        Object ringObj = new Object();

        Thread student = new Thread(() -> {
            synchronized (ringObj) {
                System.out.println("1 Students wait for the ring");
                try {
                    ringObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4 Students came out of the classroom.");
            }
        });

        // 同学们等着下课
        student.start();

        Utils.sleepIgnoreException(1000);

        // 下课铃声就要响了
        Thread bell = new Thread(() -> {
            synchronized (ringObj) {
                System.out.println("2 Bell ready to ring.  " + System.currentTimeMillis());
                ringObj.notifyAll();

                Utils.sleepIgnoreException(500);
                System.out.println("3 Bell ring ring ring. " + System.currentTimeMillis());
            }
        });

        bell.start();

    }

}
