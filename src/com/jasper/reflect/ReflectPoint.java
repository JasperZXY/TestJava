package com.jasper.reflect;
import java.lang.reflect.Field;

public class ReflectPoint {
	private int x;
	public int y;
	private static  int z = 12;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		ReflectPoint point = new ReflectPoint(1,7);
		//fieldY的值是多少？是7，错！fieldY不是对象身上的值，是类上的，因为拿到的那是字节码
		Field fieldY = Class.forName("ReflectPoint").getField("y");
		System.out.println(fieldY.get(point));
//		Field x = Class.forName("ReflectPoint").getField("x");
		Field fieldX = Class.forName("ReflectPoint").getDeclaredField("x");
//		x.setAccessible(true);
		System.out.println(fieldX.get(point));
		
		Field yy = point.getClass().getField("y");
		
		Field zz = point.getClass().getDeclaredField("z");
		zz.setAccessible(true);
		System.out.println(zz.get(null));

	}
}
