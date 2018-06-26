package com.zxy.testCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import com.sun.tools.jdi.LinkedHashMap;

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
		m4();
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
	
	public static void m4() {
		System.out.println("===================TreeMap==================");
		Map<String, String> map = new TreeMap<String, String>();
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
		System.out.println("===================TreeMap==================");
	}
	
	@Test
	public void m5() {
		Map<String, Object> map = new HashMap<>();
		map.put("1", 111);
		map.put("3", 333);
		map.put("2", 2222);
		map.put("5", 5555);
		System.out.println(map);
		
		Map<Object, Object> linkMap = new LinkedHashMap();
		linkMap.putAll(map);
		System.out.println(linkMap);
		
		Map<String, Object> treeMap = new TreeMap<>(map);
		System.out.println(treeMap);
		
	}
}
