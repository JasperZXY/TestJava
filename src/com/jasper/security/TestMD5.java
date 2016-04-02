package com.jasper.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

/**
 * MD5加密 MD5 -- message-digest algorithm 5 （信息-摘要算法）缩写， 广泛用于加密和解密技术，常用于文件校验。
 * 校验？不管文件多大，经过MD5后都能生成唯一的MD5值。 好比现在的ISO校验，都是MD5校验。
 * 
 * @author Jasper
 */
public class TestMD5 {
	public static void main(String[] args) {
		System.out.println("fcea920f7412b5da7be0cf42b8c93759".length());
		byte[] b = decode("1234567");
		System.out.println(Arrays.toString(b));
		// 通常还要用base64将其转换为字符串
		System.out.println(Base64.encodeBase64String(b));
		System.out.println(MD5("1234567"));
		System.out.println(MD5("1"));
	}

	public static byte[] decode(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] b = str.getBytes();
		md5.update(b);
		return md5.digest();
	}

	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
//		char[] charArray = inStr.toCharArray();
//		byte[] byteArray = new byte[charArray.length];
//
//		for (int i = 0; i < charArray.length; i++)
//			byteArray[i] = (byte) charArray[i];
		byte[] byteArray = inStr.getBytes();

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = (md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

}
