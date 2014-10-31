package com.jasper.regular;

import org.junit.Test;

public class StringReg {
	// 正确去除标签
	@Test
	public void html() {
		System.out.println("====");
		System.out.println("<div class=\"red\">很好</div>".replaceAll("<.*>", ""));
		System.out.println("<div class=\"red\">很好</div>".replaceAll("<[^>]*>", ""));
		System.out.println("====");
	}
	
	@Test
	public void replaceOneLine() {
		System.out.println("====");
		System.out.println("123\na b c\ndef".replaceAll("\na.*\n", "好"));
		System.out.println("====");
	}

}
