package com.jasper.testKeyword;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

public class TestFinally {
	public static void main(String[] args) {
		Inner inner = getInner();
		System.out.println(inner);
		m();
	}
	
	public static Inner getInner() {
		Inner inner = new Inner();
		try {
			inner.a = 2;
			return inner;
		} finally {
			inner.a = 3;
		}
	}
	
	public static void m() {
	}
	
	static class Inner {
		int a;
		@Override
		public String toString() {
			return "a->" + a;
		}
	}

}

