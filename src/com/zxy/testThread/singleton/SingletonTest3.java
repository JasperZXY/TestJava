package com.zxy.testThread.singleton;

/**
 * 利用静态内部类的方式来创建，因为静态属性由JVM确保第一次初始化时创建，因此也不用担心并发的问题出现。
 * 当初始化进行到一半的时候，别的线程是无法使用的，因为JVM会帮我们强行同步这个过程。另外由于静态变量只初始化一次，所以singleton仍然是单例的。
 */
public class SingletonTest3 {
    private static class SingletonHolder {
        private static final SingletonTest3 INSTANCE = new SingletonTest3();
    }

    private SingletonTest3() {
    }

    public static final SingletonTest3 getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println(SingletonTest3.getInstance());
    }
}