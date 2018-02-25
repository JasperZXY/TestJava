package com.zxy.reflect.aopframework;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {
	private long startTime;

	@Override
	public void beforeMethod(Method method) {
		System.out.println(method.getName() + " start");
		startTime = System.nanoTime();
	}

	@Override
	public void afterMethod(Method method) {
		System.out.println("method of \"" + method.getName() + "\" running time is " + (System.nanoTime() - startTime) + "ns");
		System.out.println(method.getName() + " end");
	}

}
