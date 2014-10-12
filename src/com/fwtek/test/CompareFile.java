package com.fwtek.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 比较两个文件的内容的差距
 * @author Jasper
 */
public class CompareFile {
	public static void main(String []args) {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		try {
			br1 = new BufferedReader(new FileReader("E:/test/软件找键盘1.txt"));
			br2 = new BufferedReader(new FileReader("E:/test/软件找键盘2.txt"));
			String line = "";
			ArrayList<String> list = new ArrayList<String>();
			int sum = 0;
			while((line = br2.readLine()) != null) {
				list.add(line);
			}
			while((line = br1.readLine()) != null) {
				if(! list.contains(line.toString())) {
					sum ++;
					System.out.println(line);
				}
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br1.close();
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
