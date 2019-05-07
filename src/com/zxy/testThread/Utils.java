package com.zxy.testThread;

public class Utils {

    /**
     * 由于使用Thread.sleep会抛出InterruptedException异常，影响一些测试结果，
     * 所以提供一个方法让CPU空转
     * @param millis
     */
    public static void idle(long millis) {
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < millis) {

        }
    }

    public static void sleepIgnoreException(long millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
