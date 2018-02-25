package com.zxy.testException;

class VeryImportantException extends Exception {
	@Override
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	@Override
	public String toString() {
		return "A trivial exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) throws Exception {
		LostMessage lm = new LostMessage();
		try {
			lm.f();
		} finally {
			lm.dispose();
		}
	}
	public boolean isOdd(int num) {
		return num % 2 == 1;
	}
	public boolean isEven(int num) {
		return num % 2 == 0;
	}
} // /:~

