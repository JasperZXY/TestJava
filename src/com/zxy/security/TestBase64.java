package com.zxy.security;

import org.apache.commons.codec.binary.Base64;

/**
 * 需要加入的jar包：commons-codec-1.4.jar<br/>
 *  严格地说，属于编码格式，而非加密算法
 * @author Jasper
 */
public class TestBase64 {
	
	public static void main(String[] args) {
		String string = "钟献耀";
		String encodeStr = encode(string);
		System.out.println(encodeStr);
		System.out.println(decode(encodeStr));
	}
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		return Base64.encodeBase64String(str.getBytes());
	}
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
		return new String(Base64.decodeBase64(str.getBytes()));
	}

}
