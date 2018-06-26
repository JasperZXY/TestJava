package com.zxy.JDK7;

public class TryCatch {
	public static void main(String[] args) {
		try {
			m1(2);
		} catch(Exception1|Exception2|Exception3 e) {
			e.printStackTrace();
		}
	}

	static void m1(int a) throws Exception1, Exception2, Exception3 {
		switch (a) {
		case 1:
			throw new Exception1();
		case 2:
			throw new Exception2();
		case 3:
			throw new Exception3();
		default:
			System.out.println("Success");
		}
	}
	
	static class Exception1 extends Exception {
		private static final long serialVersionUID = -6657909628777973876L;
	}
	static class Exception2 extends Exception {
		private static final long serialVersionUID = 7116507962605364617L;
	}
	static class Exception3 extends Exception {
		private static final long serialVersionUID = -3830570836105143766L;
	}

}

