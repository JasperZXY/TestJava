package com.zxy.testThread;

/**
 * Created by zhongxianyao.
 *
 * Java中有两类线程：User Thread(用户线程)、Daemon Thread(守护线程)
 *
 * 用户线程即运行在前台的线程，而守护线程是运行在后台的线程。
 * 守护线程作用是为其他前台线程的运行提供便利服务，而且仅在普通、非守护线程仍然运行时才需要，
 * 比如垃圾回收线程就是一个守护线程。当VM检测仅剩一个守护线程，而用户线程都已经退出运行时，VM就会退出，
 * 因为没有如果没有了被守护这，也就没有继续运行程序的必要了。如果有非守护线程仍然存活，VM就不会退出。
 *
 * 守护线程并非只有虚拟机内部提供，用户在编写程序时也可以自己设置守护线程。
 * 用户可以用Thread的setDaemon（true）方法设置当前线程为守护线程。
 */
public class DaemonThread implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread());
        // setDaemon为true，则"main end"打印后，整个程序就停住了，DaemonThread不会继续运行下去
        // setDaemon不设置，则"main end"打印后，在DaemonThread执行完后整个程序才会停住
        //thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
