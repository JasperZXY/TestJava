package com.jasper.testCollection;

import java.util.ArrayList;
import java.util.List;

public class ListFatherAndSon {

	public static void main(String[] args) {
		m1();
		m2();
	}
	
	public static void m1() {
		List<Son> sons = new ArrayList<Son>();
		sons.add(new Son());
		List<Father> fathers = new ArrayList<Father>(sons);
		System.out.println(fathers);
	}
	
	public static void m2() {
		List<_Son> sons = new ArrayList<_Son>();
		sons.add(new _Son());
		List<_SuperFather> fathers = new ArrayList<_SuperFather>(sons);
		System.out.println(fathers);
	}
}

class Father {
}
class Son extends Father {
}
class _SuperFather {
}
class _Father<T extends _Father<T>> extends _SuperFather {
}
class _Son extends _Father<_Son> {
}
