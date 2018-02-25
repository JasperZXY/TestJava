package com.zxy.testThread.threadpool;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 饱和策略
 */
public class SaturatedPolicy {

    /**
     * 测试结果：当线程池（threadCount）+队列数（queueCount）小于要执行任务数，则大于部分的任务将被拒绝（RejectedExecutionException）
     */
    @Test
    public void abort() {
        int threadCount = 2;
        int queueCount = 3;
        int taskCount = 6;  // 改为5，所有任务都能执行完
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCount, threadCount, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(queueCount),
                new MyThreadFactory("SaturatedPolicy"));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        dosomething(threadPoolExecutor, taskCount);

        threadPoolExecutor.shutdown();

        mysleep(3000);
    }

    /**
     * 测试结果：运行的过程中，有时主线程也被当做线程池中的一个线程了，其他的从运行的结果中看不错东西。
     */
    @Test
    public void callerRuns() {
        int threadCount = 2;
        int queueCount = 3;
        int taskCount = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCount, threadCount, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(queueCount),
                new MyThreadFactory("SaturatedPolicy"));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                System.out.println("ActiveCount:" + e.getActiveCount() + " TaskCount:" + e.getTaskCount());
                Random random = new Random();
                if (random.nextBoolean()) {
                    System.out.println("rejectedExecution true :" + r);
                } else {
                    System.out.println("rejectedExecution false");
                    super.rejectedExecution(r, e);
                }
            }
        });

        dosomething(threadPoolExecutor, taskCount);

        threadPoolExecutor.shutdown();

        mysleep(3000);
    }

    private void dosomething(ThreadPoolExecutor threadPoolExecutor, int taskCount) {
        for (int i=1; i<=taskCount; i++) {
            final int task = i;
            try {
                threadPoolExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " start " + task);
                        mysleep(200);
                        System.out.println(Thread.currentThread().getName() + " end   " + task);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " error   " + task);
            }
        }
    }

    private static void mysleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
