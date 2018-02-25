package com.zxy.testThread.testMethod;

public class ThreadJoin implements Runnable {

    public static int a = 0;

    public synchronized void inc() {
        a++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inc();
        }
    }

    public static void main(String[] args) throws Exception {

        Runnable r = new ThreadJoin();
        Thread t1 = new Thread(r);
        t1.start();

        System.out.println("======");
        //让t1执行完后再去获取a的值，这样才能获得到正确的值
        t1.join();
        System.out.println("end:" + a);
    }
}