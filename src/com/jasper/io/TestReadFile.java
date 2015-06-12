package com.jasper.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestReadFile {
	public static void main(String[] args) {
		System.out.println(getFileData("F:\\tmp\\众神之神UID2.txt"));
	}
	
	public static String getFileData(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
