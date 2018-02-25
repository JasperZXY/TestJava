package com.zxy.io;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class TestFile {
	public static void main(String[] args) {
		File file = new File("file/a.txt");
		System.out.println("exists:" + file.exists());
		System.out.println("getPath:" + file.getPath());
		System.out.println("getAbsolutePath:" + file.getAbsolutePath());
		System.out.println("toURI:" + file.toURI().toString());
		try {
			System.out.println("toURL:" + file.toURL().toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("getCanonicalPath:" + file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
