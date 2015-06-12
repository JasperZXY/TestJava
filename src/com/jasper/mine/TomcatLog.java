package com.jasper.mine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.Test;

public class TomcatLog {
	public static void main(String[] args) {
//		String filePath = "D:\\\\Download\\SecureCRT\\popup.yy.com.log.6\\popup.yy.com.log.6";
		String filePath = "D:\\\\Download\\SecureCRT\\popup.yy.com.log";
		try (FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)) {
			String line = null;
			long sum = 0;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] strings = line.split(" ");
				if (strings.length > 5) {
//					try {
//						if (strings[7].indexOf("popupUrl") > 0) {
//							sum += Integer.valueOf(strings[strings.length - 3]);
//							count ++;
//						}
//					} catch (Exception e) {
//						System.out.println(line);
//					}
					sum ++;
					try {
						if (Integer.valueOf(strings[strings.length - 3]) > 1000) {
							System.out.println(line);
							count ++;
						}
					} catch (Exception e) {
					}
				}
			}
			System.out.println(count + " " + sum / count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 分析这种日志：10.20.164.81 - - [27/Apr/2015:14:10:00 +0800] | GET /ad/getAd?appId=1008 HTTP/1.1 200 0 141 0
	 * 这里只统计请求的数量
	 * @param args
	 */
	@Test
	public void urlCount() {
		Path path = Paths.get("D:\\\\Download\\SecureCRT\\logs");
		File[] files = path.toFile().listFiles();
		System.out.println(Arrays.toString(files));
		
		String dateStr = "26/Apr";
		String line = null;
		Map<String, Integer> count = new HashMap<String, Integer>();
		
//		for (int i=0; i<4; i++) {
		for (int i=0; i<files.length; i++) {
			int lineNum = 0;
			System.out.println("start:" + files[i].getName());
			try (FileInputStream fis = new FileInputStream(files[i]);
					GZIPInputStream gzis = new GZIPInputStream(fis);
					InputStreamReader isr = new InputStreamReader(gzis);
					BufferedReader br = new BufferedReader(isr)) {
				while ((line = br.readLine()) != null) {
					lineNum ++;
					String[] strings =line.split(" ");
					if (strings.length != 13) {
						System.out.printf("error:num:%s | content:%s.\n", lineNum, line);
					} else {
						if (strings[3].contains(dateStr)) {
							String url = strings[7];
							//这里可能需要换一种更好的方式
							if (url.contains("?")) {
								url = url.substring(0, url.indexOf("?"));
							}
							Integer c = count.get(url);
							if (c == null) {
								count.put(url, 1);
							} else {
								count.put(url, c + 1);
							}
						} 
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		System.out.println("=============统计结果=============");
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			System.out.println(entry.getValue() + "\t" + entry.getKey());
		}
	}
	
	//10.20.164.81 - - [27/Apr/2015:14:10:00 +0800] | GET /ad/getAd?appId=1008 HTTP/1.1 200 0 141 0
	@Test
	public void httpCount() {
		Path path = Paths.get("D:\\\\Download\\SecureCRT\\logs\\clientad.yy.com.log.16.gz");
		File file = path.toFile();
		
		String dateStr = "26/Apr/2015:14";
		String line = null;
		int length = "[26/Apr/2015:14:".length();
		int count = 0;
		
		try (FileInputStream fis = new FileInputStream(file);
				GZIPInputStream gzis = new GZIPInputStream(fis);
				InputStreamReader isr = new InputStreamReader(gzis);
				BufferedReader br = new BufferedReader(isr)) {
			while ((line = br.readLine()) != null) {
				String[] strings =line.split(" ");
				if (strings.length == 13) {
					if (strings[3].contains(dateStr)) {
						Integer minute = Integer.parseInt(strings[3].substring(length, length + 2));
						if (minute > 30) {
							count ++;
						}
					} 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("=============统计结果=============" + count);
	}

}
