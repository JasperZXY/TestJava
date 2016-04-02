package com.jasper.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class Test {
	public static void main(String[] args) throws Exception {
		URL url = Test.class.getClassLoader().getResource("a.txt");
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println("===========");
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/networkips_city_original.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "/src/networkips_city.txt")));
		String line = null;
		String save = "";
		while ((line = br.readLine()) != null) {
			if (! save.equals(line)) {
				byte[] b = line.getBytes();
				int i=0;
				while (i<b.length && b[i] <= 0) {
					i ++;
				}
				if(i >= b.length - 1) {
					System.out.println(line);
				} else {
					save = new String(b, i, b.length - i);
					bw.write(save + "\n");
				}
			}
		}
		bw.close();
		br.close();
	}
}
