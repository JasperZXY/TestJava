package com.zxy.testClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestFile {
	public static void main(String[] args) {
		new TestFile().m();
	}

	public void m() {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("a.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
