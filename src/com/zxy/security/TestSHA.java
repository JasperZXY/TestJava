package com.zxy.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

/**
 * SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
 * 被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD5通过碰撞法都被破解了，
 * 但是SHA仍然是公认的安全加密算法，较之MD5更为安全。
 * @author Jasper
 */
public class TestSHA {
	public static void main(String[] args) {
		byte[] b = encode("钟献耀");
		System.out.println(Arrays.toString(b));
		System.out.println(Base64.encodeBase64String(b));
	}

	public static byte[] encode(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] b = str.getBytes();
		md5.update(b);
		return md5.digest();
	}
}
