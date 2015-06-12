package com.jasper.mine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class WebTest {
	static String cookie = "";
	private static final String[] urls = {
			"http://powersoft.iteye.com/blog/2146313",
			"http://powersoft.iteye.com/blog/2145973",
			"http://powersoft.iteye.com/blog/2145698",
			"http://powersoft.iteye.com/blog/2128624",
			"http://powersoft.iteye.com/blog/2128607",
			"http://powersoft.iteye.com/blog/2127163",
			"http://powersoft.iteye.com/blog/2127040",
			"http://powersoft.iteye.com/blog/2127029",
			"http://powersoft.iteye.com/blog/2126868",
			"http://powersoft.iteye.com/blog/2147091",
			"http://powersoft.iteye.com/blog/2126831",
			"http://powersoft.iteye.com/blog/2147091", 
			"http://powersoft.iteye.com/blog/2148407",
			"http://powersoft.iteye.com/blog/2152019" };

	public static void main(String[] args) {
//		int count = 0;
//		int sum = urls.length;
//		Random random = new Random();
//		while(true) {
//			count ++;
//			System.out.println(count);
//			try {
//				web(urls[random.nextInt(sum)]);
//			} catch (IOException e) {
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//				e.printStackTrace();
//			}
//		}
		try {
			System.out.println(web("http://127.0.0.1:8000/test/asyncMethod"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void a() {
		String ip = "http://172.16.41.249:8080/MovieTickets";
		try {
			String string = web(ip + "/app/movie/movie/listMovies");
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String web(String url) throws IOException {
		BufferedReader bis = null;
		InputStream is = null;
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setRequestProperty("Cookie", cookie);
			Random random = new Random();
			connection.setRequestProperty("x-forwarded-for", 
					String.valueOf(random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(198) + "." + random.nextInt(255)));
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			connection.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.11 YYE/2.3 Safari/537.36");
//		"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			cookie = connection.getHeaderField("set-cookie");
			is = connection.getInputStream();
			bis = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = bis.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

//	public static String csdnBlog(String url) throws IOException {
//		return web(
//				url,
//				"__message_district_code=440000;  __utmz=17226283.1380523565.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
//	}

}
