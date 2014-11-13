package com.jasper.reflect.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 普通bean工厂
 * @author Jasper
 */
public class BeanFactory {
	Properties props = null;
	public BeanFactory(InputStream ips) {
		props = new Properties();
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name) {
		String className = props.getProperty(name);
		Object bean = null;
		try {
			bean = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(bean instanceof ProxyBeanFactory) {
			try {
				Advice advice = (Advice) Class.forName(props.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
				ProxyBeanFactory proxyBeanFactory = (ProxyBeanFactory)bean;
				proxyBeanFactory.setAdvice(advice);
				proxyBeanFactory.setTarget(target);
				return proxyBeanFactory.getProxy();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bean;
	}

}
