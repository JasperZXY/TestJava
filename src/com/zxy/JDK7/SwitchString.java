package com.zxy.JDK7;

public class SwitchString {
	public static void main(String[] args) {
		String[] strs = {"1", new String("1")};
		
		for (String str : strs) {
			System.out.println("curStr:" + str);
			switch (str) {
			case "1":
				System.out.println("==1==");
				break;
			default :
				System.out.println("default");
			}
		}
	}

}
