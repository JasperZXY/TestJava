package com.zxy.testClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 测试Properties，但获取中文失败
 * @author Jasper
 */
public class TestProperty {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("test.properties");
		Properties properties = new Properties();
		properties.load(is);
		properties.clone();
		String hello = properties.getProperty("hello");
		System.out.println(hello);
	}

}
