package com.zxy.testThread.testMethod;

import com.zxy.testThread.Utils;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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
 * 下面的例子，两个线程遇到单数的时候进行加1，一个线程遇到偶数时进行加1，最终的输出结果是
 * <code>1,2,3,4...</code>
 *
 * <br/>
 *
 * 注意wait()/notify()/notifyAll()方法需要加synchronized同步代码块，
 * 否则会抛出 IllegalMonitorStateException 异常。
 * 同时还要注意同步块用的对象应该跟wait和notify保持一致。
 */
public class WaitAndNotify {
    static int num = 0;

    public static void main(String[] args) {

        Object lockObj = new Object();

        new Thread(() -> {
            for (int i=1; i<=20; i++) {
                if (num % 2 == 1) {
                    synchronized (lockObj) {
                        num ++;
                        System.out.println(num);
                        lockObj.notifyAll();
                    }
                }else {
                    synchronized (lockObj) {
                        while (num % 2 != 1) {
                            try {
                                lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            System.out.println("=====2=====");
        }).start();

        new Thread(() -> {
            for (int i=1; i<=20; i++) {
                if (num % 2 == 1) {
                    synchronized (lockObj) {
                        num ++;
                        System.out.println(num);
                        lockObj.notifyAll();
                    }
                }else {
                    synchronized (lockObj) {
                        while (num % 2 != 1) {
                            try {
                                lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            System.out.println("=====3=====");
        }).start();

        // num初值是0，上面的if条件不满足，走到else，会先wait
        Utils.sleepIgnoreException(300);
        new Thread(() -> {
            for (int i=1; i<=40; i++) {
                if (num % 2 == 0) {
                    synchronized (lockObj) {
                        num ++;
                        System.out.println(num);
                        lockObj.notifyAll();
                    }
                }else {
                    while (num % 2 != 0) {
                        synchronized (lockObj) {
                            try {
                                lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            System.out.println("=====4=====");
        }).start();

    }
}
