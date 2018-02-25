package com.zxy.testCollection;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		Cache<String, String> cache = new Cache<>(5);
		cache.put("1", "111");
		cache.put("2", "111");
		cache.put("3", "111");
		cache.put("4", "111");
		cache.put("5", "111");
		System.out.println(cache.keySet());
		cache.get("2");
		cache.get("3");
		cache.get("1");
        cache.put("6", "111");
        cache.put("7", "111");
		System.out.println(cache.keySet());
	}

	static class Cache<K, V> extends LinkedHashMap<K, V> {
		private int size;
		private static float loadFactor = 0.75f;
		public Cache(int size) {
			//true 代表是否用算法LRU（最近最少使用）
			super((int) (size / loadFactor), loadFactor, true);
			this.size = size;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > size;
		}
	}

}
