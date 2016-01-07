package com.jasper.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestReadFile {
	public static void main(String[] args) {
		//打包成jar给其他人使用，但需要修改配置文件时，可用这种方法，注意打包时，需要把file\a.txt放在与jar包相同的目录下
		System.out.println(getFileData(System.getProperty("user.dir") + "\\file\\a.txt"));
		System.out.println("============");
		//这种适合固定的情况，当配置文件跟代码一起打包，配置文件不需要修改的情况比较合适用这种
		System.out.println(getFileData(TestReadFile.class.getResource("/a.txt").getFile()));
		System.out.println(TestReadFile.class.getResource("/a.txt").getFile());
	}
	
	/**
	 * 用FileInputStream可以指定编码，其他的还没看到可以指定的地方，
	 * 如果不指定编码，导出jar时读取文件会出现乱码。
	 * 这是单纯为了说明问题，所以没有用close方法。
	 * @param fileName
	 * @return
	 */
	public static String getFileData(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(fileName)), "utf-8"));
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
