package com.zxy.mine;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class RunCommand {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		Process process;
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(Charset.defaultCharset());
		try {
			long curTime = System.currentTimeMillis();
			process = runtime.exec("ping 127.0.0.1");
			byte[] b = new byte[200];
			InputStream is = process.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			System.out.println("===");
			while (bis.read(b) != -1) {
				System.out.println(new String(b, "GBK"));
			}
			System.out.println("===");
			System.out.println(System.currentTimeMillis() - curTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
