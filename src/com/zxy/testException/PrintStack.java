package com.zxy.testException;

import java.io.PrintWriter;
import java.io.StringWriter;

//自定义方法进行打印异常栈
public class PrintStack {
	public static void main(String[] args) {

		try {
			int i = 0;
			i = i / i;
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(print(e));
		}

	}

	// 自定义方法进行打印
	static String print(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		return sw.toString();
	}

}
