package com.jasper.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println(Arrays.toString("😃❤".getBytes()));
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(1e1);

		System.out.println(5^3);
		System.out.println(4|2);

		System.out.println(System.currentTimeMillis() / 1000);

		Integer a = null;
		System.out.println(String.valueOf(a));
	}

	private Integer id;
	private String age;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Test test = (Test) o;

		if (id != null ? !id.equals(test.id) : test.id != null) return false;
		return age != null ? age.equals(test.age) : test.age == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (age != null ? age.hashCode() : 0);
		return result;
	}
}

