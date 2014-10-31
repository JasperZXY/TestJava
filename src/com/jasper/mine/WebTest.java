package com.jasper.mine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
			"http://powersoft.iteye.com/blog/2148407" };

	public static void main(String[] args) {
//		String cookie = "";
//		try {
//			FileReader fr = new FileReader("F:\\tmp\\iteye.txt");
//			BufferedReader br = new BufferedReader(fr);
//			cookie = br.readLine();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(cookie);
//		int i = 0;
//		while (true) {
//			System.out.println(++ i);
//			// for(int i=0; i<Integer.MAX_VALUE; i++) {
//			try {
//				int index = new Random().nextInt(urls.length);
//				web(urls[index]);
//			} catch (Exception e) {
//				e.printStackTrace();
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//			}
//		}
		// a();
		// try {
		// for(int i=0; i<1000; i++) {
		// System.out.println(i);
		// //
		// fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11606235");
		// //
		// fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605923");
		// //
		// fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605473");
		// //
		// fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605233");
		// //
		// csdnBlog("http://blog.csdn.net/zhongxianyao/article/details/12294011");
		// csdnBlog("http://blog.csdn.net/zhongxianyao/article/details/14091137");
		// web("http://www.baidu.com/link?url=uyIsdbXalsX4QwdrVXvWct8OMFphAXPuNPyogmZ30lRwhWiztZdBFQ1K1uqxMCJQ",
		// "");
		// Thread.sleep((long) (Math.random()*1000));
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

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
