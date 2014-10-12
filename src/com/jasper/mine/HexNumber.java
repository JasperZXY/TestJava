package com.jasper.mine;

/**
 * 16进制之间的转换
 * 数字和字符串之间的转换
 * @author Jasper
 */
public class HexNumber {
	final static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	public static void main(String[] args) {

		String numString = "11b";  //778966024
		System.out.println(str2Num(numString));
		System.out.println(num2Str(283));
	}
	
	public static String num2Str(int num) {
		StringBuilder sBuilder = new StringBuilder();
		while(num > 0) {
			int a = num % 16;
			num /= 16;
			sBuilder.insert(0, hex[a]);
		}
		return sBuilder.toString();
	}
	
	public static int str2Num(String str) {
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			int n = Character.digit(c, 16);
			sum = (sum << 4) + n;
		}
		System.out.println(sum);
		//Integer.parseInt("11b", 16)这个方法可以实现要的效果
		//System.out.println(Integer.parseInt("11b", 16));
		return sum;
	}

}
