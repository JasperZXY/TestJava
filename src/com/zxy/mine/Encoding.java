package com.zxy.mine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Encoding {
	public static void main(String[] args) {
		String fileName = System.getProperty("user.dir") + "\\file\\a.txt";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "utf-8"));
			String string = in.readLine();
			System.out.println(string);
			
			//下面部分是为了打出jar能够进行显示
//			JFrame jframe = new JFrame();
//			jframe.setSize(200, 200);
//			jframe.setLocation(100, 100);
//			jframe.setVisible(true);
//			jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			
//			JLabel jLabel = new JLabel(string);
//			jframe.add(jLabel);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
