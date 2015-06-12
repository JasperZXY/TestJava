package com.jasper.mine;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Test {
	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(format.parse("2015-05-12 03:01:00").getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(format.format(new Date(1000L * 1431977409)));
		System.out.println(format.format(new Date(System.currentTimeMillis() - 3 * 24 * 3600 * 1000)));
		
		System.out.println("http://szhuodong.duowan.com/s/yynews3/index.html?code=YYXX_NCSHIVT_CFIVyyqb_shxbIVNUANCHUNIV*from=from_link_YYXX ".trim() + "=");
		System.out.println(Arrays.toString(" ".getBytes()));
		System.out.println(Arrays.toString(" ".getBytes()));
		System.out.println(Arrays.toString(" ".getBytes()));
		
//		ProcessBuilder pb = new ProcessBuilder( "cmd.exe", "/c", "ping", "-n", "1", "172.0.0.1");
//		Process process;
//		try {
//			process = pb.start();
//			System.out.println(process);
//			System.out.println(loadStream(process.getInputStream()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("===" + System.getProperty("line.separator") + "===");
		
		System.out.println(Test.class.getResource("/"));
		System.out.println(Test.class.getResource("/").getPath());
		System.out.println(Test.class.getResource("/").getFile());
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
}