package com.zxy.testThread.testClass;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 测试await设置超时时间
 *
 * 测试结果，如果在timeout前获取到锁，await返回false，否则返回true
 */
public class ConditionTest2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                long time = System.currentTimeMillis();
                lock.lock();
                System.out.println("await start");
                boolean result = condition.await(1, TimeUnit.SECONDS);
                System.out.println("await result:" + result);
                System.out.println("await end " + (System.currentTimeMillis() - time) + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread-await").start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("signal start");
                TimeUnit.SECONDS.sleep(5);  // 上面await 1秒，这里就设置5秒
                condition.signal();
                System.out.println("signal end");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("signal unlock");
            }
        }, "Thread-signal").start();

    }
}
