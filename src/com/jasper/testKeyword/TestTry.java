package com.jasper.testKeyword;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestTry {
	public static void main(String[] args) {
		System.out.println(m1());
		System.out.println(m2());
		System.out.println(m3());
		System.out.println(getMap1());
		System.out.println(getMap2());
		System.out.println(getMap3());
//		new TestTry().fun(1);
	}

	// 结果：try
	public static String m1() {
		String x;
		try {
			x = "try";
			return x;
		} finally {
			x = "finally";
		}
	}

	// 结果：finally
	public static String m2() {
		try {
			return "try";
		} finally {
			return "finally";
		}
	}

	// 结果：finally
	public static String m3() {
		String x;
		try {
			x = "try";
			return print(x);
		} finally {
			x = "finally";
			return print(x);
		}
	}

	// {key=finally}
	// 这个例子测试引用
	public static Map<String, String> getMap1() {
		Map<String, String> map = new HashMap<>();
		map.put("key", "init");

		try {
			map.put("key", "try");
			return map;
		} finally {
			map.put("key", "finally");
		}
	}

	// 结果：{key=try}
	public static Map<String, String> getMap2() {
		Map<String, String> map;

		try {
			map = Collections.singletonMap("key", "try");
			return map;
		} finally {
			map = Collections.singletonMap("key", "finally");
		}
	}

	// {key=finally}
	public static Map<String, String> getMap3() {
		Map<String, String> map;

		try {
			map = Collections.singletonMap("key", "try");
			return map;
		} finally {
			map = Collections.singletonMap("key", "finally");
			return map;
		}
	}

	private static String print(String a) {
		System.out.println("print:" + a);
		return a;
	}

	public void fun(final int c) {
		final int a[] = {1};
		final int b;
		
		
		class A {
			public void m() {
				a[0] = 2;
				if(c > 4) {
				}
			}
		}
		
		new A().m();
		System.out.println(a[0]);
	}
	
}
