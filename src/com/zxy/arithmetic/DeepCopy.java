package com.zxy.arithmetic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <h1>深度复制</h1>
 * 通过这个程序，也从侧面反映了，即使一个类被设计成了单例，还是通过深度复制，要看类的设计。
 * 所以要看这个类是继承哪一个类或实现哪一个接口，都不要是Serializable的子类就可以了，不然就还要写readResolve()方法
 * @author Jasper
 */
public class DeepCopy implements Serializable {
	private static final long serialVersionUID = 5373018661200569687L;

	public static DeepCopy INSTANCE = new DeepCopy();

	private DeepCopy() {
	}

	//注释掉这个方法的话，下面将打印false，说明这并不是一个真正的单例
	//要订正这个问题，可在这个类中添加一个readResolve 方法，它可以将那个隐藏的
	//构造器转变为一个隐藏的静态工厂（static factory），以返回原来那个的DeepCopy实例
	private Object readResolve() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		DeepCopy deepCopy = (DeepCopy) copy(DeepCopy.INSTANCE);
		System.out.println(deepCopy == DeepCopy.INSTANCE);
	}

	public static Object copy(Object obj) {
		try {
			ByteArrayOutputStream bos = 
					new ByteArrayOutputStream();
			ObjectOutputStream oos = 
					new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.close();
			ByteArrayInputStream bin = 
					new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = 
					new ObjectInputStream(bin);
			Object object = ois.readObject();
			ois.close();
			return object;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

}
