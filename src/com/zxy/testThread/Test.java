package com.zxy.testThread;


import com.zxy.other.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * zhongxianyao
 */
public class Test {

    private static final int N = 3;
    private int count = 0;
    private int finishCount = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void doSomething() {
        for (int i=0; i<1000_000; i++) {
            synchronized (this) {
                count ++;
            }
        }
        lock.lock();
        finishCount ++;
        if (finishCount == N) {
            condition.signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (int i=0; i<N; i++) {
            Runnable runnable = () -> test.doSomething();
            new Thread(runnable).start();
        }

        test.lock.lock();
        try {
            test.condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            test.lock.unlock();
        }

        System.out.println(test.count);
    }

}

