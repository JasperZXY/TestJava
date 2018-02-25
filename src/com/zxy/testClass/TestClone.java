package com.zxy.testClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestClone {
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
	
	public static void main(String[] args) {
		User user = new User("Jasper");
		System.out.println(user);
		User userCopy = (User) copy(user);
		System.out.println(userCopy);
		SingleUser singleUser = SingleUser.getInstance();
		System.out.println(singleUser);
		SingleUser singleUser2 = (SingleUser) copy(singleUser);
		System.out.println(singleUser2);
	}

}

class User implements Serializable {
	private static final long serialVersionUID = 2913452915577784104L;
	private String name;
	public User(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class SingleUser implements Serializable {
	private static final long serialVersionUID = 33748436371919304L;
	private final static SingleUser USER = new SingleUser("single");
	private String name;
	private SingleUser(String name) {
		this.setName(name);
	}
	public static SingleUser getInstance() {
		return USER;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Object readResolve() {
		return USER;
	}
	
}
