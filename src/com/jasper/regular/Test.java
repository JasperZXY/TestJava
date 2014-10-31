package com.jasper.regular;
import java.util.regex.*;

import javax.swing.JOptionPane;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("\\b\\d\\.?\\b");
		Pattern pattern = Pattern.compile("\\b\\s*\\d{1,3}\\.?\\D+");
//		Pattern pattern = Pattern.compile("\\b\\s*\\d{1,3}\\.\\D+|\\b\\s*\\d{1,3}[^.]\\D+");
//		Pattern pattern = Pattern.compile("\\b\\.\\D+");
		String input;
		while(true) {
			input = JOptionPane.showInputDialog(null, "输入数据");
			if(input == null) {
				System.exit(0);
				break;
			}
			System.out.println("input->" + input);
			Matcher matcher = pattern.matcher(input);
			boolean find = matcher.find();
			System.out.println("有找到吗？-》" + find);
			if(find) {
				System.out.println("count->" + matcher.groupCount());
				System.out.println(matcher.group());
			}
		}
	}

}
