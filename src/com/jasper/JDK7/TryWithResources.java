package com.jasper.JDK7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TryWithResources {
	public static void main(String[] args) {
		try (InputStreamReader isr = new FileReader(System.getProperty("user.dir") + "/file/tmp");
				BufferedReader br = new BufferedReader(isr)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (OutputStreamWriter osw = new FileWriter(System.getProperty("user.dir") + "/file/write_new");) {
			for (int i = 0; i < 100; i++) {
				osw.write(Integer.toString(i) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
