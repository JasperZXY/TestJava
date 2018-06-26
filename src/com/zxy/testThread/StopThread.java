package com.zxy.testThread;

import java.util.concurrent.TimeUnit;

/**
 *  测试线程的停止
 */
public class StopThread {
    private static boolean stopRequest = false;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            int i = 0;
            while (! stopRequest) {
                System.out.println(i ++);
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stopRequest = true;
    }
}
