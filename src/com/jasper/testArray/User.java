package com.jasper.testArray;

public class User implements Comparable {
	private int id;
	private String name;
	
	public User() {}
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " name:" + name;
	}
	@Override
	public int compareTo(Object o) {
		return this.id - ((User)o).getId();
	}

}
