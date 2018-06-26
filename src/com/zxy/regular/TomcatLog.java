package com.zxy.regular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TomcatLog {
	public static void main(String[] args) {
		String fileName = "F:\\tmp\\web.sub.yy.com.log.1";
		Pattern pattern = Pattern.compile("(\\[.*?\\]).*?GET /fans/invite/index.*?HTTP/1.1 200 ([\\d]*) [\\d]* ([\\d]*)");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
//					System.out.println(matcher.group(0) + matcher.group(1));
					int processTime = Integer.parseInt(matcher.group(2));
					int responTime = Integer.parseInt(matcher.group(3));
					if (processTime > 1000 || responTime > 1000) {
//						System.out.println("date:" + matcher.group(1));
						System.out.println("process:" + processTime);
						System.out.println("respon:" + responTime);
						System.out.println("data:" + matcher.group(0));
						System.out.println("================");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
