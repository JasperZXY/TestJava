package com.zxy.io;

import java.io.*;

/**
 * IO 转换
 */
public class ConverIO {
    public static void main(String[] args) {
        String filePath = Thread.currentThread().getClass().getResource("/a.txt").getFile();
        System.out.println("filePath:" + filePath);

        // read
        try (
                FileInputStream fis = new FileInputStream(filePath);
                InputStream is = fis;
                ObjectInputStream ois = new ObjectInputStream(is);
                PipedInputStream pis = new PipedInputStream();
//                FilterInputStream filterInputStream = new FilterInputStream(is);
                FilterInputStream bis = new BufferedInputStream(is);
                FilterInputStream dis = new DataInputStream(is);

                InputStreamReader isr = new InputStreamReader(is);   // InputStream转Reader
                FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr);
                StringReader sr = new StringReader(filePath);
        ) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        // write
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                OutputStream os = fos;
                ObjectOutputStream oos = new ObjectOutputStream(os);
                PipedOutputStream pos = new PipedOutputStream();
                FilterOutputStream filterOutputStream = new FilterOutputStream(os);
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(os);

                OutputStreamWriter osw = new OutputStreamWriter(os);  // OutputStream转Writer
                FileWriter fw = new FileWriter(filePath);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
