package com.jasper.testCollection;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		//true 代表是否用算法LRU（最近最少使用）
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(20, .75f, true);
		map.put("1", "111");
		map.put("2", "111");
		map.put("3", "111");
		map.put("4", "111");
		map.put("5", "111");
		System.out.println(map.keySet());
		map.get("2");
		map.get("3");
		map.get("1");
		System.out.println(map.keySet());
	}

}
