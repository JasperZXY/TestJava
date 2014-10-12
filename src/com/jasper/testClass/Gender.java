package com.jasper.testClass;

public enum Gender implements Mouse {
	Male("男"),
	Female("女");
	private final String name;
	
	private Gender(String name) {
		this.name = name;
	}

	@Override
	public void say() {
		System.out.println(name);
		
	}

}
