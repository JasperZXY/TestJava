package com.zxy.testThread.proAndCus;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 */
public class ReadAndWrite3 {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i=0; i<2; i++) {
            new Thread(() -> {
                while (true) {
                    int num = (int) (Math.random() * 100);
                    myQueue.put(num);
                    System.out.println(Thread.currentThread().getName() + " " + num);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }, "ThreadPut-" + i).start();
        }

        for (int i=0; i<10; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + myQueue.take());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "ThreadTake-" + i).start();
        }
    }

    static class MyQueue<T> {
        private static final int SIZE = 3;
        private Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();  //写线程条件
        private final Condition notEmpty = lock.newCondition(); //读线程条件
        private List<T> list = new LinkedList<>();

        public void put(T t) {
            try {
                lock.lock();
                while (list.size() >= SIZE) {
                    notFull.await();
                }
                list.add(t);
                notEmpty.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public T take() {
            try {
                lock.lock();
                while (list.size() == 0) {
                    notEmpty.await();
                }
                T t = list.remove(0);
                notFull.signalAll();
                return t;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
        }
    }
}
