package com.zxy.testThread.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by zhongxianyao. Time 2019/4/22 8:30 PM Desc 文件描述
 *
 * 尝试过去掉volatile进行测试，运行了多次没遇到报错的情况
 *
 * https://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java
 *
 * https://stackoverflow.com/questions/7855700/why-is-volatile-used-in-double-checked-locking
 *
 * The real problem is that Thread A may assign a memory space for instance
 * before it is finished constructing instance.
 * Thread B will see that assignment and try to use it.
 * This results in Thread B failing because it is using a partially constructed version of instance.
 */
public class SingletonTest1 {
    //private static SingletonTest1 singleton;
    private static volatile SingletonTest1 singleton;

    private int a;


    public int getA() {
        return a;
    }


    public void setA(int a) {
        this.a = a;
    }


    private SingletonTest1() {}

    public static final SingletonTest1 getInstance() {
        if (singleton == null) {
            synchronized (SingletonTest1.class) {
                if (singleton == null) {
                    singleton = new SingletonTest1();
                }
            }
        }
        return singleton;
    }



    public static void main(String[] args) {
        int count = 4;
        ExecutorService threadPool = new ThreadPoolExecutor(count, count, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        for (int i=0; i<count; i++) {
            int index = i;
            threadPool.execute(() -> {
                SingletonTest1 test = SingletonTest1.getInstance();
                System.out.printf("index:%d time:%d hashCode:%s a:%d\n", index, System.currentTimeMillis(), test.hashCode(), test.getA());
                test.setA(index);
            });
        }

        threadPool.shutdown();

    }

}
