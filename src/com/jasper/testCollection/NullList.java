package com.jasper.testCollection;

import java.util.ArrayList;
import java.util.List;

public class NullList {
	private static List<String> list = null;
	
	private static List<String> retList() {
		return list;
	}
	
	public static void main(String[] args) {
		List<String> retList = retList();
		if (retList == null) {
			retList = new ArrayList<String>();
		}
		retList.add("a");
		
		System.out.println(retList());
	}

}
