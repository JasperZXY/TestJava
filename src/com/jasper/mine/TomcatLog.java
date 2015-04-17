package com.jasper.mine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TomcatLog {
	public static void main(String[] args) {
		String filePath = "D:\\\\Download\\SecureCRT\\popup.yy.com.log.3\\popup.yy.com.log.3";
		try (FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)) {
			String line = null;
			long sum = 0;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] strings = line.split(" ");
				if (strings.length > 5) {
					try {
						if (strings[7].indexOf("popupDetails") > 0) {
							sum += Integer.valueOf(strings[strings.length - 3]);
							count ++;
						}
					} catch (Exception e) {
						System.out.println(line);
					}
				}
			}
			System.out.println(sum / count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
