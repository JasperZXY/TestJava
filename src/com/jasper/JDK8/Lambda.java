package com.jasper.JDK8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <strong>Lambda 表达式</strong><br/>
 * 可以使代码代码变得更短，具有可读性
 * 
 * @author Jasper
 *
 */
public class Lambda {
	public static void main(String[] args) {
		//旧版本排序
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		System.out.println(names);
		
		//新版本排序
		names = Arrays.asList("peter", "anna", "mike", "xenia");
//		Collections.sort(names, (String a, String b) -> {
//		    return b.compareTo(a);
//		});
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
		
		new Thread(() -> {
			for (int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
