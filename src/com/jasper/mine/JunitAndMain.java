package com.jasper.mine;

/**
 * 下面是通过运行Thread来验证
 * <ul>
 * <li>在运行main方法过程中，会等待线程执行完再退出；</li>
 * <li>而在运行junit测试用例中，则不会等待线程执行完再退出。</li>
 * </ul>
 *
 */
public class JunitAndMain {
    /**
     * 输出结果
     * start
     * end
     */
    public static void main(String[] args) {
        m();
    }

    /**
     * 输出结果
     * 有时为空，有时只输出start
     */
    @org.junit.Test
    public void junit() {
        m();
    }

    private static void m() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        }).start();
    }
}
