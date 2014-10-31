package com.jasper.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/networkips_city_original.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "/src/networkips_city.txt")));
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != "") {
			System.out.println(Arrays.asList(line.getBytes()));
			line = br.readLine();
			System.out.println(Arrays.asList(line.getBytes()));
			bw.write(line + "\n");
			if(count ++ == 10) break;
		}
	}
}
