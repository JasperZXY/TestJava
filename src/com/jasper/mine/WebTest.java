package com.jasper.mine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebTest {
	public static void main(String[] args) {
		try {
			for(int i=0; i<100; i++) {
				String ret = web("http://mp.weixin.qq.com/s?__biz=MjM5NDQ5MDk4Ng==&mid=201081678&idx=2&sn=cda3f3e1bd37a40f6bb8a6cf4b070ea9&key=a607f98078cd05fea959b5862d93d186d17f21aeb3c42d02bc2bc522c5934796c49c27bb312c09cdbd2f500eadd13505&ascene=1&uin=MjY1OTQ1&pass_ticket=aJ%2Bz88u2b%2BOwUmq9Zwgk55z%2B%2FQWpVcbFztXHjW2B6sw%3D", "");
				System.out.println(ret);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		a();
//		try {
//			for(int i=0; i<1000; i++) {
//				System.out.println(i);
////				fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11606235");
////				fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605923");
////				fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605473");
////				fetch_url("http://blog.csdn.net/zhongxianyao/article/details/11605233");
////				csdnBlog("http://blog.csdn.net/zhongxianyao/article/details/12294011");
//				csdnBlog("http://blog.csdn.net/zhongxianyao/article/details/14091137");
//				web("http://www.baidu.com/link?url=uyIsdbXalsX4QwdrVXvWct8OMFphAXPuNPyogmZ30lRwhWiztZdBFQ1K1uqxMCJQ", "");
//				Thread.sleep((long) (Math.random()*1000));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
	public static void a() {
		String ip = "http://172.16.41.249:8080/MovieTickets";
		try {
			String string = web(ip + "/app/movie/movie/listMovies", null);
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String web(String url, String cookie) throws IOException {
		BufferedReader bis = null;
		InputStream is = null;
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setRequestProperty("Cookie", cookie);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			connection
					.setRequestProperty("User-Agent",
							"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
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
	
	public static String csdnBlog(String url) throws IOException {
		return web(url, "__message_district_code=440000;  __utmz=17226283.1380523565.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
	}

}
