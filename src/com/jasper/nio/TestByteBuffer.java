package com.jasper.nio;

import java.nio.ByteBuffer;

public class TestByteBuffer {
	public static void main(String[] args) {
		String str = "helloWorld";
		System.out.println(str.length());
		ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit());
		// 读取两个字节
		System.out.println((char)buff.get());
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit());
		buff.mark();
		System.out.println("mark position:" + buff.position() + "\t limit:"
				+ buff.limit());
		buff.get();
		buff.get();
		buff.reset();
		System.out.println("reset position:" + buff.position() + "\t limit:"
				+ buff.limit());
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit());
		buff.put(buff.position(), (byte) 'z');
		System.out.println("position:" + (char)buff.get(buff.position())
				+ "\t limit:" + buff.limit());
		
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit());
		System.out.println("position:" + (char)buff.get(buff.position())
				+ "\t limit:" + buff.limit());
		buff.compact();
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit());
	}

}
