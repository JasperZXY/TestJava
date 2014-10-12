package com.jasper.duotai;

public class Father {
	private int id;

	public void say() {
		System.out.println("I'm father");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		final int b = 2;
		class A {
			int m() {
				return b * 2;
			}
		}
	}

}
