package com.zxy.testThread.testClass;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 *
 *  Condition它更强大的地方在于：能够更加精细的控制多线程的休眠与唤醒。
 *  对于同一个锁，我们可以创建多个Condition，就是多个监视器的意思。
 *  在不同的情况下使用不同的Condition。
 *  例如，假如多线程读/写同一个缓冲区：当向缓冲区中写入数据之后，唤醒"读线程"；
 *  当从缓冲区读出数据之后，唤醒"写线程"；
 */
public class ConditionTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("await start");
                condition.await();
                System.out.println("await end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread1").start();

        // 为了确保Thread1比Thread2先运行
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("signal start");
                condition.signal();
                System.out.println("signal end");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("signal unlock");
            }
        }, "Thread2").start();
    }
}
