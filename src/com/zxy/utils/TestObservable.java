package com.zxy.utils;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by zhongxianyao.
 *
 * TODO 后续需要完善，补充说明适用哪些场景
 */
public class TestObservable extends Observable {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        final TestObservable testObservable = new TestObservable();
        int obsCount = 10;
        int dataCount = 1000;
        for (int i=1; i<=obsCount; i++) { // 搞10个观察者
            testObservable.addObserver(new MyObserver());
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(16);
        for (int i=1; i<=dataCount; i++) {
            threadPool.execute(() -> {
                testObservable.setChanged();
                testObservable.notifyObservers();
                try {
                    Thread.sleep(10);
                }catch (Exception e) {
                }
            });
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
        /*
        期望结果是 obsCount * dataCount，但实际上不是。
        changed是个全局锁。如果多个NotifyObserers运行，抢到锁之后，就清除clearChanged（set changed = false）的。导致其他的进来直接就返回了。
         */
        System.out.println(counter.get());
    }

    public static class MyObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            counter.getAndAdd(1);
        }
    }


}
