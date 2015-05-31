package com.jasper.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;


//MethodHandle java7新引进的，用来取代反射
public class TestMethod {
	public static void main(String[] args) {
		MethodHandle mh = null;
		MethodType methodGet = MethodType.methodType(int.class);
		MethodType methodSet = MethodType.methodType(void.class, int.class);
		MethodHandles.Lookup lookup = MethodHandles.lookup();  //获取上下文
		
		
		try {
			Object targetObj = Class.forName("com.jasper.invoke.MyBean").newInstance();
			
			mh = lookup.findVirtual(MyBean.class, "setX", methodSet);   //从上下文查找方法句柄
			mh.invoke(targetObj, 12);
			System.out.println(targetObj.toString());
			
			//这个方法只能调用public的，不能调用private的
			lookup.findSetter(MyBean.class, "y", int.class).invoke(targetObj, 33);
			System.out.println(targetObj.toString());
			
			mh = lookup.findVirtual(MyBean.class, "getX", methodGet);
			System.out.println(mh.invoke(targetObj));
		} catch (NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
