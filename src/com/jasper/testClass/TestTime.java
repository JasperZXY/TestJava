package com.jasper.testClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			System.out.println(((Date)format.parseObject("2014-11-04 24:00")).getTime());
			System.out.println(((Date)format.parseObject("2014-11-04 24:00")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(format.format(new Date(System.currentTimeMillis())));
		System.out.println(format.format(new Date(System.currentTimeMillis() - 70000)));
		System.out.println(format.format(new Date(1413374812000L)));
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 11, 31);
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		
		System.out.println(format.format(new Date(1418581053000L)));
		System.out.println(format.format(new Date(1418644483863L)));
		System.out.println(format.format(new Date(1418644810651L)));
		System.out.println(format.format(new Date(1418787431148L)));
		System.out.println(format.format(new Date(1418870458523L)));
	}

}