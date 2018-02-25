package com.zxy.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

public class SplitFile {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
	
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		System.out.println("start: " + new Date());
		try {
            fr = new FileReader("F:\\\\tmp\\uid\\uid.csv");
            br = new BufferedReader(fr);
            
            //这里配置的是20M最大一个文件的
//            for (int i=1; i<=5; i++) {
//            	String fileName = String.format("F:\\\\tmp\\uid\\uid-8号-%02d-200w.txt", i);
//            	split(br, fileName, 2000000);
//            }
//            
//            for (int i=1; i<=10; i++) {
//            	String fileName = String.format("F:\\\\tmp\\uid\\uid-9号-%02d-170w.txt", i);
//            	split(br, fileName, 1700000);
//            }
//            for (int i=11; i<=15; i++) {
//            	String fileName = String.format("F:\\\\tmp\\uid\\uid-9号-%02d-160w.txt", i);
//            	split(br, fileName, 1600000);
//            }
//            
//            for (int i=1; i<=6; i++) {
//            	String fileName = String.format("F:\\\\tmp\\uid\\uid-10号-%02d-150w.txt", i);
//            	split(br, fileName, 1500000);
//            }
//            split(br, "F:\\\\tmp\\uid\\uid-10号-07-100w.txt", 1000000);
//            
//            split(br, "F:\\\\tmp\\uid\\uid-11号-01-125w.txt", 1250000);
//            split(br, "F:\\\\tmp\\uid\\uid-11号-02-125w.txt", 1250000);
//            
//            split(br, "F:\\\\tmp\\uid\\uid-12号-01-120w.txt", 1200000);
//            split(br, "F:\\\\tmp\\uid\\uid-12号-02-120w.txt", 1200000);
            
            
          //这里配置的是_100M最大一个文件的
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-8号-1kw.txt", 10000000);
            
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-9号-1-500w.txt", 5000000);
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-9号-2-500w.txt", 5000000);
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-9号-3-500w.txt", 5000000);
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-9号-4-500w.txt", 5000000);
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-9号-5-500w.txt", 5000000);
            
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-10号-1-500w.txt", 5000000);
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-10号-2-500w.txt", 5000000);
            
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-11号-250w.txt", 2500000);
            
            split(br, "F:\\\\tmp\\uid\\_100M\\uid-12号-250w.txt", 2500000);
            
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
        	closeIO(br);
        	closeIO(fr);
        }
		System.out.println("end: " + new Date());
	}
	
	static void split(BufferedReader br, String fileName, int count) {
		int i = 0;
		String line = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			while ((line = br.readLine()) != null && i < count) {
				line = line.substring(1, line.length() - 1);
				if (isNum(line)) {
					bw.write(line + "\n");
					i ++;
				} else {
					System.err.printf("fileName:%s, count:%d read string[%s] error, not num \n", fileName, count, line);
				}
			}
		} catch (Exception e) {
			System.err.printf("fileName:%s, count:%d error \n", fileName, count);
			e.printStackTrace();
		} finally {
			closeIO(bw);
			closeIO(fw);
		}
	}
	
	static void closeIO(Closeable obj) {
		if (obj != null) {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static boolean isNum(String str) {
		return NUMBER_PATTERN.matcher(str).matches();
	}

}
