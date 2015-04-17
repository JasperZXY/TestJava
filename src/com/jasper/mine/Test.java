package com.jasper.mine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date(1429099954253L)));
		System.out.println(format.format(new Date(1429099994250L)));
		
		System.out.println(1429099984250L - 1429099954253L);
		System.out.println(1429099994250L - 1429099954253L);
	}
	
}