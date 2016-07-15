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
			System.out.println(((Date)format.parseObject("2015-02-01 00:00:00")).getTime());
			System.out.println(((Date)format.parseObject("2015-02-28 00:00:00")).getTime());
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
		
		System.out.println(format.format(new Date(1422497100000L)));

		System.out.println(new java.sql.Date(System.currentTimeMillis()));
		System.out.println(new java.sql.Time(System.currentTimeMillis()));
		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));

	}

}
