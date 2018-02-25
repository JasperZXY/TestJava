package com.zxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 用反射去调用main方法，并且还传了数组类型的参数
 * @author Jasper
 */
public class TestMain {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String className = args[0];
		Method mainMethod = Class.forName(className).getMethod("main", String[].class);
		mainMethod.invoke(null, (Object)new String[]{"1", "22", "333"});
	}

}

class TestArguments {
	public static void main(String[] args) {
		for(String arg: args) {
			System.out.println(arg);
		}
	}
}
