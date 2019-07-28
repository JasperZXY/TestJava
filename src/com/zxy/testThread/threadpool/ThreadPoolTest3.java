package com.zxy.testThread.threadpool;

import java.util.concurrent.*;

/**
 * 线程池submit方法使用
 */
public class ThreadPoolTest3 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(() -> {
            System.out.println("get data ing...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "abc";
        });

        System.out.println("after");

        threadPool.shutdown();

        try {
            System.out.println("result:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
