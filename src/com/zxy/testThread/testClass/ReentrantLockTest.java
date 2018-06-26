package com.zxy.testThread.testClass;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
//        reentrant();
//        tryLock();
        interrupt();
    }

    private static void reentrant() {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " lock 1");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " lock 2");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    lock.unlock();  // 多少个lock()，就对应多少个unlock()
                }
            }).start();
        }
    }

    /*
     tryLock 如果没有设置超时时间，则直接返回是否成功获取到锁，
     如果设置超时时间，则在timeout时间内阻塞式地获取锁，成功返回true，是否返回false。
     代码写起来比较复杂，需要各种判断，而且没有成功获取到锁，最后不能调用unlock()
     */
    public static void tryLock() {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                boolean status = false;
                try {
                    status = lock.tryLock(1, TimeUnit.SECONDS);
                    if (status) {
                        System.out.println(Thread.currentThread().getName() + " lock " + lock.isLocked() + " " + status);
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " thread end " + lock.isLocked());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " is lock " + lock.isLocked());
                    if (status) {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }

    /*
    lock()  阻塞式地获取锁，只有在获取到锁后才处理interrupt事件
    lockInterruptibly() 阻塞式地获取锁，立即处理interrupt事件，并抛出异常
     */
    private static void interrupt() {
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("1 lock");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("1 unlock");
                lock.unlock();
            }
        });
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(() -> {
            try {
//                lock.lockInterruptibly();
                lock.lock();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("2 lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread2.start();

        System.out.println("interrupt");
        thread2.interrupt();
    }

}
