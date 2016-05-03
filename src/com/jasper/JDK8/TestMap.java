package com.jasper.JDK8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jasper
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		System.out.println(map);
		
		map.forEach((id, val) -> System.out.println(id + ":" + val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));             // val33
		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));     // false
		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true
		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));             // val33
		map.computeIfAbsent(13, num -> "bam");
		System.out.println(map.get(13));             // bam
		
		// 键跟值匹配才会删除
		map.remove(3, "val3");
		System.out.println(map.get(3));;             // val33
		map.remove(3, "val33");
		System.out.println(map.get(3));;             // null
		
		System.out.println(map.getOrDefault(42, "not found"));
		
		// merge 如果对应的key没有值，则插入，有则合并
		System.out.println(map.get(5));            // val5
		map.merge(5, "xxx", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(5));            // val5xxx
		map.merge(5, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(5));             // val5xxxconcat
		
		System.out.println(map.get(10));            // null
		map.merge(10, "xxx", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(10));            // xxx
		map.merge(10, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(10));             // xxxconcat
		
	}

}
