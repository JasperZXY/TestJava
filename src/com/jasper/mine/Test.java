package com.jasper.mine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Test extends AAA implements aa {
	public final static String A_STRING = "String Test";
	private static final String[] IMG_EXT = {".jpg", ".jpeg", ".png", ".gif", ".bmp"}; 
//	public final static String GET_STRING() {
//		return "fang fa";
//	}
	void a() {
		System.out.println("TEst");
	}
	public static int count = 0;
	
	public Test() {
		count ++;
	}

	public static void main(String[] args) {
		System.out.println(A_STRING);
		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 11, 31);
		calendar.add(calendar.DATE, 1);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(Y.Z);
		new Test().b();
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() + 24*60*60*1000);
		
		System.out.println(getFileExt("http://yy.com/lic_-4519797480952726047"));
		System.out.println(isValidateImageName("http://asdf.jpg?afsd"));
		
		Integer integer = Integer.valueOf("12");
		Integer integer2 = new Integer(12);
		System.out.println(integer == integer2);
		System.out.println(integer.equals(integer2));
		System.out.println(System.currentTimeMillis());
		
		List<String> list = new LinkedList<String>();
		list.add("12");
		list.add("13");
//		String[] strings = (String[]) list.toArray();
		String[] strings = new String[list.size()];
		list.toArray(strings);
		System.out.println(strings[0] + strings[1]);
		System.out.println(60*60*4);
		System.out.println(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(((Date)format.parseObject("2014-08-05 00:00:00")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []strings1 = {"1", "2"};
		List<String> list2 = Arrays.asList(strings1);
		Collections.reverse(Arrays.asList(strings1));
		list2.toArray(strings1);
		System.out.println(strings1[0]);
		System.out.println(format.format(new Date(System.currentTimeMillis() + 14400000000L)));
		System.out.println(format.format(new Date(1412697810000L)));
		System.out.printf("12%%%n34");
		System.out.println("===");
		System.out.println(Integer.MAX_VALUE);
		int i = -1;
		long ll = i;
		System.out.println(ll);
		System.out.println(intToLong(-1));
		System.out.println("\"123");
		
		System.out.println(System.currentTimeMillis());
		long startTime = System.currentTimeMillis();
		Set<String> set = new HashSet<String>();
		for(int ii=0; ii<100000; ii++) {
			set.add(UUID.randomUUID().toString());
		}
		System.out.println(set.size());
		System.out.println(System.currentTimeMillis() - startTime);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		mm(map);
		System.out.println(map.get("flag"));
		System.out.println(new Date(Long.valueOf("54262906", 16) * 1000));
		System.out.println(new Date(1411787023970L));
		System.out.println(Long.toHexString(1411787023970L));
		System.out.println(System.currentTimeMillis());
		long lll = 12;
		double dd = 12.0;
		System.out.println(dd == lll);
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
	}
	
	public static void mm(Map<String, Boolean> map) {
		map.put("flag", true);
		try {
			return;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			map.put("flag", false);
		}
	}
	
	public static long intToLong(int i) {
        if (i < 0) {
            long mm = (long) Integer.MAX_VALUE + 1;
            return (mm << 1) + i;
        }
        return i;
    }
	
	private static boolean isValidateImageName(String fileName) {
		int index = fileName.lastIndexOf(".");
		if(index < 0) {
			return false;
		}
		String ext = fileName.substring(index);
		for(int i=0; i<IMG_EXT.length; i++) {
			if(IMG_EXT[i].equalsIgnoreCase(ext)) {
				return true;
			}
		}
		return false;
	}
	
	public static String getFileExt(String name) {
		int suffix_index = name.lastIndexOf('.');
		String suffix = "";
		if (suffix_index > 0) {
			suffix = name.substring(suffix_index);
			int idx = suffix.indexOf("?");
			if (idx > 0) {
				suffix = suffix.substring(0, idx);
			}
		}
		return suffix;
	}
	
	static class Y {
		static int Z;
	}
//	static int Y = 12;

	private static void workHard() {
		try {
			System.out.println("work");
			workHard();
		} finally {
			System.out.println("finally");
			workHard();
		}
	}

	private static boolean thirdElementIsThree(int[] a) {
		System.out.println(a.length);
		return a.length >= 3 & a[2] == 3;
	}

	@Override
	public void f() {

	}

}

class AAA {
	public final static String A_STRING = "String";
	public final static String GET_STRING() {
		return "fang fa";
	}
	
	void b() {
		a();
	}
	void a() {
		System.out.println("AAA");
	}
}

class BBB extends AAA {
	void a() {
		System.out.println("BBB");
	}
}

interface aa {
	void f() throws CloneNotSupportedException;
}

interface bb {
	void f() throws InterruptedException;
}

interface abb extends aa, bb {
}