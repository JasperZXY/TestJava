package com.jasper.testThread.proAndCus;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 多线程读，多线程写
 *
 * 用BlockingQueue实现
 */
public class ReadAndWrite2 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i=0; i<2; i++) {
            write(queue);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0; i<2; i++) {
            read(queue);
        }

    }

    private static void write(BlockingQueue<Integer> queue) {
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int num = random.nextInt(100);
                try {
                    queue.put(num);
                    System.out.println(Thread.currentThread().getName() + " write:" + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void read(BlockingQueue<Integer> queue) {
        new Thread(() -> {
            while (true) {
                Integer num = null;
                try {
                    num = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  read:" + num);
            }
        }).start();
    }

}
