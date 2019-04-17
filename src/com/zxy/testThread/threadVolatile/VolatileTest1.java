package com.zxy.testThread.threadVolatile;

/**
 * 这是个失败的例子
 *
 * 测试结果
 * 1、flag变量有没有volatile关键字进行修饰，"set end"打印后还是打印了一大堆"a=0"
 * 2、如果get()方法里面的while循环不进行"System.out.println"，那么在没有volatile修饰flag变量时，get()方法会死循环
 */
public class VolatileTest1 {
    int a = 0;
    Object p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, pa, pb, pc, pd, pe, pf;  // 这一行也不影响运行结果
    volatile boolean flag = false;

    public static void main(String[] args) {
        VolatileTest1 demo = new VolatileTest1();
        System.out.println("availableProcessors:" + Runtime.getRuntime().availableProcessors());

        for (int i=0; i<100; i++) {
            final int index = i;
            new Thread(() -> demo.get(index)).start();
        }

        new Thread(() -> {
            try {
                // 保证 get 一定在 set 之前
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("set start");
            demo.set();
            System.out.println("set end");
        }).start();

    }

    public void set() {
        a = 1;
        flag = true;
    }

    public void get(int index) {
        while(true) {
            /*
            还是有个地方不是很明白，在flag没有关键字volatile进行修饰，
            如果不进行System.out.println，而且其他的数字运算，这里会死循环，所以加了这行代码进行测试
             */
            System.out.println("index:" + index + " a=" + a);
            if (flag) break;
        }
        System.out.println("===index:" + index + " end a=" + a);
    }

}
