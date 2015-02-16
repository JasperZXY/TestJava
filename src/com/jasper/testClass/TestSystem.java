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
		
		System.out.println("==============");
		System.out.println("==============");
		
		m();
	}
	
	//从输出结果看，System设置err的输出流是全局的
	public static void m() {
		for (int j=0; j<20; j++) {
			final int k = j;
			new Thread(new Runnable() {
				@Override
				public void run() {
					if (k == 1) {
						PrintStream ps = System.err;
						ByteOutputStream bos = new ByteOutputStream();
						
						try {
							int i = 0;
							i = 1 / i;
						} catch (Exception e) {
							System.setErr(new PrintStream(bos));
							try {
								Thread.sleep(200);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
							System.setErr(new PrintStream(ps));
						}
						
						System.out.println("=====");
						System.out.println(bos.toString());
						System.out.println("=====");
					} else {
						System.err.println(Thread.currentThread().getName());
					}
				}
			}).start();
		}
	}

}
