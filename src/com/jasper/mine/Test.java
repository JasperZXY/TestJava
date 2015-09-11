package com.jasper.mine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Test {
	static Map<Integer, List<String>> ipWhiteList = new HashMap<>();

	// static {
	// System.out.println("#111".startsWith("#"));
	// System.out.println("﻿100".startsWith("#"));
	// String filePath =
	// Test.class.getClassLoader().getResource("ipwhitelist.properties").toString().substring(5);
	// System.out.println("filePath:" + filePath);
	//
	// System.out.println("=========");
	// System.out.println((int)Math.ceil(2.3));
	// System.out.println((int)Math.ceil(2.0));
	// try (FileReader fr = new FileReader(filePath);
	// BufferedReader br = new BufferedReader(fr)) {
	//
	// String line = null;
	// while ((line = br.readLine()) != null) {
	// System.out.println(line);
	// if (! line.startsWith("##")) {
	// String[] pros = line.split("=");
	// if (pros.length != 2) {
	// System.out.println("==========ServerServiceController file error");
	// // break;
	// continue;
	// }
	// String[] ips = pros[1].split(",");
	// ipWhiteList.put(Integer.valueOf(pros[0]), Arrays.asList(ips));
	// }
	// }
	//
	// System.out.println("allIp:" + ipWhiteList);
	// } catch (IOException e) {
	// System.err.println("ServerServiceController static init IOException");
	// e.printStackTrace();
	// } catch (Exception e) {
	// System.err.println("ServerServiceController static init error");
	// e.printStackTrace();
	// }
	// System.out.println("ServerServiceController init success");
	//
	// }
	public static void main(String[] args) {
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// try {
		// System.out.println(format.parse("2015-05-12 03:01:00").getTime() /
		// 1000);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// System.out.println(format.format(new Date(1000L * 1431977409)));
		// System.out.println(format.format(new Date(System.currentTimeMillis()
		// - 3 * 24 * 3600 * 1000)));
		//
		// System.out.println("http://szhuodong.duowan.com/s/yynews3/index.html?code=YYXX_NCSHIVT_CFIVyyqb_shxbIVNUANCHUNIV*from=from_link_YYXX ".trim()
		// + "=");
		// System.out.println(Arrays.toString(" ".getBytes()));
		// System.out.println(Arrays.toString(" ".getBytes()));
		// System.out.println(Arrays.toString(" ".getBytes()));
		//
		// // ProcessBuilder pb = new ProcessBuilder( "cmd.exe", "/c", "ping",
		// "-n", "1", "172.0.0.1");
		// // Process process;
		// // try {
		// // process = pb.start();
		// // System.out.println(process);
		// // System.out.println(loadStream(process.getInputStream()));
		// // } catch (IOException e) {
		// // e.printStackTrace();
		// // }
		//
		// System.out.println("===" + System.getProperty("line.separator") +
		// "===");
		//
		// System.out.println(Test.class.getResource("/"));
		// System.out.println(Test.class.getResource("/").getPath());
		// System.out.println(Test.class.getResource("/").getFile());
		//
		// List<?> list = new ArrayList<>();
		// aaa(list.getClass());
		// System.out.println(Integer.parseInt("10", 16));
		//
		// System.out.println("==========");
		// for (int i=0; i<3; i++) {
		// System.out.println(("aa" + i).equals("aa1"));
		// }

//		Point point = new Point();
//		point.x = 10;
//		point.y = 20;
//		WeakReference<Point> weakReference = new WeakReference<Point>(point);
//		System.out.println(point);
//		System.out.println(weakReference.get());
//		new Do(point).doSomething();
//		point = null;
//		System.gc();
//		// System.out.println(point);
//		// System.out.println(weakReference.get());
//		try {
//			Thread.sleep(3500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		int count = 1290;
		if (count < 1000) {
            System.out.println(count);
        } else if (count < 10_000) {
            System.out.println(String.format("%.1fk", 1.0f * count / 1000));
        } else {
        	System.out.println("10K+");
        }
		
	}

	public static class Do {
		private final WeakReference<Point> weakReference;

		// private Point point;
		public Do(Point point) {
			weakReference = new WeakReference<Point>(point);
			// this.point = point;
		}

		public void doSomething() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.gc();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(weakReference);
					System.out.println(weakReference.get());
					// System.out.println(point);
				}
			}).start();
		}
	}

	public static class Point {
		public float x;
		public float y;

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		in = new BufferedInputStream(in);
		StringBuffer buffer = new StringBuffer();
		try {
			while ((ptr = in.read()) != -1) {
				buffer.append((char) ptr);
			}
		} finally {
			in.close();
		}
		return buffer.toString();
	}

	public static <T> void aaa(Class<T> rClass) {
		System.out.println(rClass.getGenericSuperclass());
		System.out
				.println(rClass.getGenericSuperclass() instanceof Collection<?>);
		T t;
	}
}