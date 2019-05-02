package com.zxy.testThread.testClass;

import com.zxy.testThread.Utils;

public class ThreadDeathTest {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i=0; i<10; i++) {
                if (i == 6) {
                    // 线程直接结束，控制台也没有异常信息
                    throw new ThreadDeath();
                }
                System.out.println(i);
            }
        }).start();

        Utils.sleepIgnoreException(100);
        System.out.println("main end");
    }
}
