package com.jasper.testUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(((Date)format.parseObject("2014-11-04 14:35:00")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(format.format(new Date(System.currentTimeMillis() + 14400000000L)));
		System.out.println(format.format(new Date(1413374812000L)));
	}

}
