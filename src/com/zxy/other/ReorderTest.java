package com.zxy.other;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * http://ifeve.com/java-memory-model-1/comment-page-1/#comment-27416
 */
public class ReorderTest {
    private int a = 0;
    private int b = 0;

    public static void main(String[] args) throws InterruptedException,
        ExecutionException {
        ReorderTest rt = new ReorderTest();
        rt.doTest();
    }

    public void doTest() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

//可能出现的结果（关注ThreadATask，ThreadBTask取到的结果）
        int num00 = 0; //x=0，y=0
        int num10 = 0; //x=1，y=0
        int num02 = 0; //x=0，y=2
        int num12 = 0; //x=1，y=2

//可能出现的结果（关注主线程取到的结果）
        int main00_a = 0;
        int main10_a = 0;
        int main02_a = 0;
        int main12_a = 0;

//可能出现的结果（关注主线程取到的结果）
        int main00_b = 0;
        int main10_b = 0;
        int main02_b = 0;
        int main12_b = 0;

        int allNum = 100000;
        for (int i = 0 ; i < allNum ; i++) {

            CountDownLatch latch = new CountDownLatch(1);
            Future futureA = executor.submit(new ThreadATask(latch));
            Future futureB = executor.submit(new ThreadBTask(latch));
            latch.countDown();
            if (a == 0 && b == 0) {
                main00_a++;
            }
            if (a == 1 && b == 0) {
                main10_a++;
            }
            if (a == 0 && b == 2) {
                main02_a++;
            }
            if (a == 1 && b == 2) {
                main12_a++;
            }

            int x = (Integer) futureB.get(); //取得a
            int y = (Integer) futureA.get(); //取得b

            if (x == 0 && y == 0) {
                num00++;
            }
            if (x == 1 && y == 0) {
                num10++;
            }
            if (x == 0 && y == 2) {
                num02++;
            }
            if (x == 1 && y == 2) {
                num12++;
            }

            if (a == 0 && b == 0) {
                main00_b++;
            }
            if (a == 1 && b == 0) {
                main10_b++;
            }
            if (a == 0 && b == 2) {
                main02_b++;
            }
            if (a == 1 && b == 2) {
                main12_b++;
            }

            //重置状态
            a = 0;
            b = 0;
        }
        System.out.println("a=0，b=0出现次数：" + main00_a);
        System.out.println("a=1，b=0出现次数：" + main10_a);
        System.out.println("a=0，b=2出现次数：" + main02_a);
        System.out.println("a=1，b=2出现次数：" + main12_a);

        System.out.println("");
        System.out.println("x=0，y=0出现次数：" + num00);
        System.out.println("x=1，y=0出现次数：" + num10);
        System.out.println("x=0，y=2出现次数：" + num02);
        System.out.println("x=1，y=2出现次数：" + num12);

        System.out.println("");
        System.out.println("a=0，b=0出现次数：" + main00_b);
        System.out.println("a=1，b=0出现次数：" + main10_b);
        System.out.println("a=0，b=2出现次数：" + main02_b);
        System.out.println("a=1，b=2出现次数：" + main12_b);
        executor.shutdown();
    }

    private class ThreadATask implements Callable {
        private CountDownLatch barrier;

        public ThreadATask(CountDownLatch barrier) {
            this.barrier = barrier;
        }

        public Integer call() throws InterruptedException,
            BrokenBarrierException {
            barrier.await(); //

            a = 1; // A1
            return b; // A2
        }
    }

    private class ThreadBTask implements Callable {
        private CountDownLatch barrier;

        public ThreadBTask(CountDownLatch barrier) {
            this.barrier = barrier;
        }

        public Integer call() throws InterruptedException,
            BrokenBarrierException {
            barrier.await();

            b = 2; // B1
            return a; // B2
        }
    }
}