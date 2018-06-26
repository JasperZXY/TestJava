package com.zxy.testClass;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class StringTest {
	private final int b;
	
	public StringTest() {
		b = 12;
	}
	
	public StringTest(int b) {
		this.b = b;
	}
	
	protected static String a = "12";
	public static void main(String[] args) throws Exception {
//		String string = "0123";
//		System.out.println(string.split("3").length);
//		System.out.println(string.substring(string.indexOf("1")));
		String aString = "a";
		String cString = "a";
		String bString = new String("a");
		System.out.println(aString.hashCode());
		System.out.println(bString.hashCode());
		System.out.println(aString == bString);
		System.out.println(aString == cString);
		
		byte[] b = "汉字".getBytes("UTF-8");
		System.out.println(new String(b));
		
		String []strings = {"张三", "李四", "王五"};
		Arrays.sort(strings, Collator.getInstance(Locale.CHINA));
		System.out.println(Arrays.asList(strings));
		System.out.println(new StringTest(11).b);
		System.out.println(String.format("this is %s, I'm %d", "Jasper", 19));
		
		String string = "/admin/index/welcome";
		System.out.println(string.startsWith("/admin/index/"));
	}
}
