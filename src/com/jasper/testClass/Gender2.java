package com.jasper.testClass;

public enum Gender2 implements Mouse {
	Male("男") {
		@Override
		public void say() {
			System.out.println("男的");
		}
	},
	Female("女") {
		@Override
		public void say() {
			System.out.println("女的");
		}
	};
	private final String name;
	private Gender2(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
