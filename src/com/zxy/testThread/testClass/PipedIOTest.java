package com.zxy.testThread.testClass;

import com.zxy.testThread.Utils;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入/输出流和普通文件的输入/输出流或者网络输入、输出流不同之处
 * 在于管道输入/输出流主要用于线程之间的数据传输，而且传输的媒介为内存。
 *
 * 管道输入/输出流主要包括下列两类的实现：
 * 面向字节： PipedOutputStream、 PipedInputStream
 * 面向字符: PipedWriter、 PipedReader
 */
public class PipedIOTest {

    public static void main(String[] args) throws Exception {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();

        // 必须调用connect()方法，至于谁调用谁没太大所谓
        //pipedReader.connect(pipedWriter);
        pipedWriter.connect(pipedReader);

        new Thread(() -> {
            try {
                while (true) {
                    char[] data = new char[11]; // 随便设置一个大小
                    int len = pipedReader.read(data);
                    if (len < 0) {
                        break;
                    }
                    System.out.print(new String(data));
                }
                pipedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        Utils.sleepIgnoreException(1000);

        new Thread(() -> {
            try {
                for (int i=1; i<=100; i++) {
                    pipedWriter.write(i + "");
                    if (i % 10 == 0) {
                        pipedWriter.write("\n");
                    }
                }
                pipedWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

}
