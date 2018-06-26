package com.zxy.reflect.aopframework;

import java.io.InputStream;
import java.util.Collection;

/**
 * 这个包下的所有类都是为了试验Spring的AOP framework
 * @author Jasper
 */
public class Test {
	public static void main(String[] args) {
		InputStream ips = Test.class.getResourceAsStream("config.properties");
		BeanFactory beanFactory = new BeanFactory(ips);
		Collection collection = (Collection) beanFactory.getBean("xxx");
		System.out.println(collection.getClass().getName());
		collection.add("1");
		collection.add("2");
		collection.add("1");
		System.out.println(collection.size());
	}

}
