package com.zxy.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {

    public static void main(String[] args) {
        //管道输出流
        PipedOutputStream out = new PipedOutputStream();
        //管道输入流
        PipedInputStream in = new PipedInputStream();
        try {
            //in = new PipedInputStream(out);
            in.connect(out);
            Thread read = new Thread(new Read(in));
            Thread write = new Thread(new Write(out));
            //启动线程
            read.start();
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Write implements Runnable {
    PipedOutputStream pos = null;

    public Write(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            System.out.println("程序将在1秒后写入数据，请稍等。。。");
            Thread.sleep(1000);
            pos.write("随便来条数据".getBytes());
            pos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pos != null) {
                    pos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Read implements Runnable {
    PipedInputStream pis = null;

    public Read(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        byte[] buf = new byte[1024];
        try {
            System.out.println("开始读。。。");
            pis.read(buf);
            System.out.println("read：" + new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pis != null) {
                    pis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}