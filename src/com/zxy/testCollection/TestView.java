package com.zxy.testCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestView {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", Integer.valueOf(1));
		map.put("2", Integer.valueOf(2));
		Set<String> set = map.keySet();
		System.out.println(set);
		map.remove("1");
		System.out.println(set);
		set.remove("2");
		System.out.println(map);
	}

}
