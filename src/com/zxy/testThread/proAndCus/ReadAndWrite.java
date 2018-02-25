package com.zxy.testThread.proAndCus;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 多线程读，多线程写
 *
 * 使用wait/notify进行实现
 */
public class ReadAndWrite {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<5; i++) {
            write(list);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0; i<3; i++) {
            read(list);
        }
    }

    private static void write(List<Integer> list) {
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int num = random.nextInt(100);
                System.out.println(Thread.currentThread().getName() + " write:" + num);
                synchronized (list) {
                    list.add(num);
                    list.notify();
                }
            }
        }).start();
    }

    private static void read(List<Integer> list) {
        new Thread(() -> {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 若是用notifyAll，这里就需要判断一下
                    Integer num = list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "  read:" + num);
                }
            }

        }).start();
    }
}
