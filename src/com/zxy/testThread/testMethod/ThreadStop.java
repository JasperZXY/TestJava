package com.zxy.testThread.testMethod;

import com.zxy.testThread.Utils;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html
 *
 * Why is Thread.stop deprecated?
 * 在调用stop()后，会ThreadDead静默地杀死线程，并且该线程会解锁所有已经锁定的监视器，
 * 如果之前有监视器保护的对象中就会处于不一致的状态(inconsistent state)，
 * 则其他线程现在可以看到这个不一致的状态，这个对象就称为损坏的(damaged)。
 */
public class ThreadStop extends Thread {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public ThreadStop(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized(ThreadStop.class) {
            // 这里不进行try catch也是可以的，
            try {
                a = 10;

                System.out.println("=====");

                long i = 1;
                long time = System.currentTimeMillis();
                while (System.currentTimeMillis() - time < 100) {
                /*
                用了stop()后，这个方法最后一个数字偶尔会打印两次，并且还不换行
                 */
                    System.out.println(i ++);
                }

                b = 20;
            } catch (ThreadDeath ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadStop thread1 = new ThreadStop(1, 2);
        ThreadStop thread2 = new ThreadStop(1, 2);
        System.out.println("=====1 a:" + thread1.getA() + " b:" + thread1.getB());
        System.out.println("=====2 a:" + thread2.getA() + " b:" + thread2.getB());
        thread1.start();

        Utils.sleepIgnoreException(10);
        thread2.start();

        Utils.idle(50);
        thread1.stop();

        Utils.sleepIgnoreException(1000);
        System.out.println("=====1 a:" + thread1.getA() + " b:" + thread1.getB());
        System.out.println("=====2 a:" + thread2.getA() + " b:" + thread2.getB());
    }
}
