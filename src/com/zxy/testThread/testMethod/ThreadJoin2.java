package com.zxy.testThread.testMethod;

/**
 * 并行变窜行
 */
public class ThreadJoin2 {
    public static void main(String[] args) {
        for (int i=0; i<6; i++) {
            final int cur = i;
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start cur=" + cur);

                try {
                    Thread.currentThread().sleep((long) (Math.random() * 1000));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " end  cur=" + cur);
            });

            thread.start();
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " join  cur=" + cur);
        }

        System.out.println("end");
    }
}
