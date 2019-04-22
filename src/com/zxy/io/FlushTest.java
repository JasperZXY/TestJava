package com.zxy.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhongxianyao. Time 2019/4/21 3:36 PM Desc 文件描述
 */
public class FlushTest {
    private static final String FILE_PATH = System.getProperty("user.home") + "/tmp/flush_test.txt";

    public static void main(String[] args) {
        System.out.println("FILE_PATH:" + FILE_PATH);
        try (
                FileOutputStream fos = new FileOutputStream(new File(FILE_PATH));
                OutputStreamWriter osw1 = new OutputStreamWriter(fos);
                OutputStreamWriter osw2 = new OutputStreamWriter(fos);
        ) {
            osw1.write("11111111\n");
            osw1.write("11111111\n");
            osw1.write("11111111\n");
            osw2.write("2\n");
            osw2.write("2\n");
            osw2.write("2\n");
            osw2.write("2\n");
            osw2.write("2\n");
            osw2.write("2\n");
            osw1.flush();
            osw2.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("1:" + read());
        deleteFile();
        System.out.println("==========");

        for (int i=1; i<=2; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try(
                        FileOutputStream fos = new FileOutputStream(new File(FILE_PATH));
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                ) {
                    if (index == 1) {
                        osw.write("11111111\n");
                        osw.write("11111111\n");
                        osw.write("11111111\n");
                    }else {
                        osw.write("2\n");
                        osw.write("2\n");
                        osw.write("2\n");
                        osw.write("2\n");
                        osw.write("2\n");
                        osw.write("2\n");
                    }
                    System.out.println(index + ":" + System.currentTimeMillis());
                    osw.flush();
                } catch (Exception e) {
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
            /*
            多次运行后，会有这三种情况，而且第三种情况的1打印有点特殊
            [11111111, 11111111, 11111111]
            [2, 2, 2, 2, 2, 2]
            [2, 2, 2, 2, 2, 2, 11111, 11111111]
             */
            System.out.println("2===:" + read());
        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteFile();
        System.out.println("==========");

    }

    private static List<String> read() {
        List<String> list = new ArrayList<>();
        try (FileReader fr = new FileReader(new File(FILE_PATH));
             BufferedReader br  = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void deleteFile() {
        new File(FILE_PATH).delete();
    }

}
