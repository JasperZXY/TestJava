package com.jasper.testCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 待研究，居然运行没错
 * @author Jasper
 *
 */
public class SafetyCollection {
	private List<String> list = null;
	private Set<String> set = null;
	private Map<String, Integer> map = null;

	@Test
	public void testList() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		List<String> _list = new ArrayList<>();
		_list.add("1");
		_list.add("22");
		_list.add("33");
		list = _list;
//		list = Collections.synchronizedList(_list);
//		list = Collections.unmodifiableList(_list);
		
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				for (String string : list) {
//				for (int i=0; i<list.size(); i++) {
//					String string = list.get(i);
					System.out.printf(string + " ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		});
		
		_list = new ArrayList<>();
		_list.add("a");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		_list.add("bb");
		list = _list;
		System.err.println(list);
//		list = Collections.synchronizedList(_list);
//		list = Collections.unmodifiableList(_list);
		
		threadPool.shutdown();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSet() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		

		Set<String> _set = new HashSet<>();
		_set.add("1");
		_set.add("22");
		set = _set;
//		set = Collections.synchronizedSet(_set);
//		set = Collections.unmodifiableList(_set);
		
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				for (String string : set) {
					System.out.printf(string + " ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		});
		
		_set = new HashSet<>();
		_set.add("a");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		_set.add("bb");
		set = _set;
//		set = Collections.synchronizedSet(_set);
//		set = Collections.unmodifiableList(_set);
		
		threadPool.shutdown();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMap() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		
		Map<String, Integer> _map = new HashMap<>();
		_map.put("1", 1);
		_map.put("22", 22);
		map = _map;
		
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					System.out.printf(entry + " ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		});
		
		_map = new HashMap<>();
		_map.put("a", 1323);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		_map.put("bb", 33);
		map = _map;
		System.err.println(map);
		
		threadPool.shutdown();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
