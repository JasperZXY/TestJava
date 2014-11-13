package com.jasper.reflect;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestMethod {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
//		 Method charAt = Class.forName("java.lang.String").getMethod("charAt", int.class);
//		 String str = "abc";
//		 System.out.println(charAt.invoke(str, 1));
//		 System.out.println(str.charAt(1));
		 
		 Method mainMethod = Class.forName("ReflectPoint").getMethod("main", String[].class);
		 mainMethod.invoke(null, (Object)new String[]{});
		 System.out.println(mainMethod.getAnnotation(Override.class));
	}
	


}
