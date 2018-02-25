package com.zxy.mine;

import java.util.Random;

public class Password {
	public static void main(String[] args) {
		String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_$_$";
		Random random = new Random();
		for (int i=0; i<40; i++) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int j=0; j<random.nextInt(5) + 15; j++) {
				stringBuffer.append(baseString.charAt(random.nextInt(baseString.length())));
			}
			System.out.println(stringBuffer.toString());
		}
	}

}
