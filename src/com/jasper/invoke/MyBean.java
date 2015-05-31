package com.jasper.invoke;

public class MyBean {
	public static final int FINAL_VALUE = 100;
	
	private int x;
	public int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		return "MyBean [x=" + x + ", y=" + y + "]";
	}

}
