package com.zxy.testThread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 主要验证 corePoolSize maximumPoolSize workQueueCount taskCount 这4者的关系
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        int workQueueCount = 20;
        int taskCount = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(workQueueCount), new MyThreadFactory("TEST1"));

        for (int i=0; i<taskCount; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();

    }

}
