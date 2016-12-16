package com.jasper.testThread.testClass;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架是Java7中新增的一项特性，也是Java7平台的其中一项主要改进。
 *
 * Fork就是把一个大任务切分为若干子任务并行的执行，Join就是合并这些子任务的执行结果，最后得到这个大任务的结果。
 */
public class ForkJoin {
    public static void main(String[] args) {
        MyTask mt = new MyTask(16);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long curTime = System.currentTimeMillis();
        Future<Integer> result = forkJoinPool.submit(mt);

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("time:" + (System.currentTimeMillis() - curTime));
        forkJoinPool.shutdown();
    }

    // 计算1*1+2*2+3*3+...........的值
    static class MyTask extends RecursiveTask<Integer> {
        int count;
        int i = 1;

        public MyTask(int count) {
            this.count = count;
        }

        private MyTask(int i, int count) {
            this.i = i;
            this.count = count;
        }

        @Override
        protected Integer compute() {
            System.out.println("i:" + i + " " + Thread.currentThread().getName());
            if (i >= count) {
                return i * i;
            }
            MyTask newTask2 = new MyTask(i + 1, count);
            newTask2.fork();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return i * i + newTask2.join();

        }

    }
}
