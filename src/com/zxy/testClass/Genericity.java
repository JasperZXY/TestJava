package com.zxy.testClass;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Genericity {
	public static void main(String[] args) {
		System.out.println(new ADAO().getSubClass());
	}
}

abstract class DAO<o extends Serializable, T extends Domain> {
	@SuppressWarnings("unchecked")
	public Class<T> getSubClass() {
		Type ptype = this.getClass().getGenericSuperclass();
		if(ptype instanceof ParameterizedType) {  //判断是否有用到泛型
			ParameterizedType type = (ParameterizedType)ptype;
			Type[] classes = type.getActualTypeArguments();  //获取到泛型中的类型
			return (Class<T>)classes[1];   //如果确定了泛型所在的下标，也可以直接指定
//			for(int i=0; i<classes.length; i++) {
//				if(contain(((Class)classes[i]).getInterfaces())) {
//					return (Class)classes[i];
//				}
//			}
		}
		return null;
	}
	
	public static boolean contain(Class[] classes) {
		for(int i=0; i<classes.length; i++) {
			if(classes[i].getName().equals(Domain.class.getName())) {
				return true;
			}
		}
		return false;
	}
}

interface Domain {
	
}

class DomainObject implements Domain {
	
}

class ADAO extends DAO<Serializable, DomainObject> {
	
}

