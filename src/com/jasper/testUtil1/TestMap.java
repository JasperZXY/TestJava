package com.jasper.testUtil1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {
	
	public static void main(String []args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("12", Integer.valueOf(1));
		map.put("12", map.get("12")+1);
		System.out.println(map);
		System.out.println("======================");
		m1();
		m2();
		m3();
	}
	
	public static void m1() {
		System.out.println("==================第一种变量map的方式===================");
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "111");
		map.put("3", "333");
		map.put("2", "2222");
		map.put("5", "5555");
		map.put("4", "4444");
		map.put(null, "nn");
		map.put(null, null);
		for(String string  : map.keySet()) {
			System.out.println(string + "->" + map.get(string));
		}
		System.out.println("===================第一种变量map的方式==================");
	}
	
	public static void m2() {
		System.out.println("===================第二种变量map的方式==================");
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "111");
		map.put("3", "333");
		map.put("2", "2222");
		map.put("5", "5555");
		map.put("4", "4444");
		Iterator<String> iterator = map.values().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("===================第二种变量map的方式==================");
	}

	public static void m3() {
		System.out.println("===================第三种变量map的方式==================");
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "111");
		map.put("3", "333");
		map.put("2", "2222");
		map.put("5", "5555");
		map.put("4", "4444");
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		System.out.println("===================第三种变量map的方式==================");
	}
}
