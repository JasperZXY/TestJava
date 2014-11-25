package com.jasper.testCollection;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMapAndHashtable {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("1", "1");
		map.put("2", null);
		map.put(null, null);
		System.out.println(map);
		
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		table.put("1", "1");
//		table.put("2", null);  //会抛空指针异常
//		table.put(null, null); //会抛空指针异常
		System.out.println(table);
		
	}

}
