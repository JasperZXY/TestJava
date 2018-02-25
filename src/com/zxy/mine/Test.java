package com.zxy.mine;

public class Test {
    public static void main(String[] args) {
        System.out.println("123");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    System.out.println(Thread.currentThread().getName() + "i");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    System.out.println(Thread.currentThread().getName() + "i");
                }
            }
        }).start();
    }
}


