package com.zxy.nio;

import java.nio.IntBuffer;

import org.junit.Test;

public class TestIntBuffer {
	
	@Test
	public void testWrite() {
		System.out.println("testWrite");
		IntBuffer buffer = IntBuffer.allocate(10);
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.put(1);
		buffer.put(2);
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}
	
	@Test
	public void testWriteAndRead() {
		System.out.println("testWriteAndRead");
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(1);
		buffer.put(2);
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.flip();  //从写模式到读模式
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		System.out.println(buffer.get());
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}
	
	/**
	 * flip：limit = position;position = 0;
	 * clear：position = 0;limit = capacity;
	 */
	@Test
	public void testClear() {
		System.out.println("testClear");
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(1);
		buffer.put(2);
		buffer.flip();  //从写模式到读模式，0到limit之间是可以读取的数据
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		System.out.println(buffer.get());
		buffer.clear(); //可以理解为转入写模式，0到limit之间是可以读取的数据
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		System.out.println(buffer.get());
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}
	
	/**
	 * compact：读过的数据会清掉，然后未读数据前移
	 * position变成是可以用于开始写的位置
	 */
	@Test
	public void testCompact() {
		System.out.println("testCompact");
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(1);
		buffer.put(2);
		buffer.put(3);
		buffer.flip();
		System.out.println(buffer.get());
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.compact();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.flip();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		System.out.println(buffer.get());
		System.out.println(buffer.get());
		try {
			System.out.println(buffer.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}
	
	@Test
	public void testMark() {
		System.out.println("testMark");
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(1);
		buffer.put(2);
		buffer.put(3);
		buffer.flip();
		buffer.get();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.mark();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.get();
		buffer.reset();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}
	
	/**
	 * rewind:position = 0;
	 * 重新读
	 */
	@Test
	public void testRewind() {
		System.out.println("testRewind");
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(1);
		buffer.put(2);
		buffer.put(3);
		buffer.flip();
		buffer.get();
		buffer.get();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
		buffer.rewind();
		System.out.println("position=" + buffer.position() + " limit=" + buffer.limit());
	}

}
