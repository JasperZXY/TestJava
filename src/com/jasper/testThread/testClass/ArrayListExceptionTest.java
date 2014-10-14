package com.jasper.testThread.testClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExceptionTest {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
//		Collection<String> collection = new CopyOnWriteArrayList<String>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		Iterator<String> iterator = collection.iterator();
		String removeStr = "2";
		while(iterator.hasNext()) {
			String string = iterator.next();
			if(removeStr.equals(string)) {
//				collection.remove(string);  //这样删除数据是会出错的，要用下面的语，或者上面new ArrayList的时候用线程安全的CopyOnWriteArrayList类
				iterator.remove();
			} else {
				System.out.println(string);
			}
		}
		for(String string : collection) {
			if(removeStr.equals(string)) {
				collection.remove(string);
			} else {
				System.out.println(string);
			}
		}
	}

}
