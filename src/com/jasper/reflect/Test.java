package com.jasper.reflect;
import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws Exception {
		ReflectPoint point = new ReflectPoint(1, 7);
		Field y = Class.forName("ReflectPoint").getField("y");
		System.out.println(y.get(point));
		// Field x = Class.forName("ReflectPoint").getField("x");
		Field x = Class.forName("ReflectPoint").getDeclaredField("x");
		// x.setAccessible(true);
		System.out.println(x.get(point));
	}

}
