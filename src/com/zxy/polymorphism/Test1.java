package com.zxy.polymorphism;

public class Test1 {
	public static void main(String[] args) {
		Son[] sons = new Son[1];
		Father[] fathers = sons;
		fathers[0] = new Father();
		// throw java.lang.ArrayStoreException
		sons[0].say();
	}

}

