package com.zxy.regular;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

public class StringReg {
	// 正确去除标签
	@Test
	public void html() {
		System.out.println("====");
		System.out.println("1<div class=\"red\">很好</div>".replaceAll("<.*>", ""));
		System.out.println("2<div class=\"red\">很好</div>".replaceAll("<[^>]*>", ""));
		System.out.println("3<div class=\"red\">很好</div>".replaceAll("[[:alnum:]]", "#"));
		System.out.println("====");
		try {
			System.out.println(URLEncoder.encode("=", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void replaceOneLine() {
		System.out.println("====");
		System.out.println("123\na b c\ndef".replaceAll("\na.*\n", "好"));
		System.out.println("====");
	}

}
