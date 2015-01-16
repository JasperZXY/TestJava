package com.jasper.testClass;

import java.io.PrintStream;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * 重定向输出流
 * @author Jasper
 */
public class TestSystem {
	public static void main(String[] args) {
		PrintStream ps = System.err;
		ByteOutputStream bos = new ByteOutputStream();
		
		try {
			int i = 0;
			i = 1 / i;
		} catch (Exception e) {
			System.setErr(new PrintStream(bos));
			e.printStackTrace();
			System.setErr(new PrintStream(ps));
		}
		
		System.out.println("=====");
		System.out.println(bos.toString());
	}

}
