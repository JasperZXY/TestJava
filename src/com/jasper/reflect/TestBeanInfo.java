package com.jasper.reflect;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class TestBeanInfo {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		String propertyName = "y";
		Object value = 7;
		setProperty(pt1, propertyName, value);
		// 先通过调用普通java类的方法的方式获得结果，然后在这之前插入BeanUtil的get和set操作，见下面的代码。
		System.out.println(pt1.getY());
		System.out.println(getProperty(pt1, propertyName));
	}

	private static Object getProperty(ReflectPoint pt1, String propertyName) {
		Object retVal = null;
		PropertyDescriptor pd = null;
		try {
			pd = new PropertyDescriptor(propertyName, pt1.getClass());
			//注意这里是getReadMethod
			retVal = pd.getReadMethod().invoke(pt1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

	private static void setProperty(Object pt1, String propertyName,
			Object value) {

//		PropertyDescriptor pd2;
//		try {
//			pd2 = new PropertyDescriptor(propertyName, pt1.getClass());
//			pd2.getWriteMethod().invoke(pt1, value);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				if (pd.getName().equals(propertyName)) {
					pd.getWriteMethod().invoke(pt1, value);
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
