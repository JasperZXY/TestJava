package com.zxy.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class TestFileChannel {
	private static final String FILE_DIR = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator;

	@Test
	public void testRead() throws Exception {
		String filePath = FILE_DIR + "tmp";
		System.out.println(filePath);

		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(40);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

	@Test
	public void testTransferFrom() throws Exception {
		RandomAccessFile fromFile = new RandomAccessFile(FILE_DIR + "tmp", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		RandomAccessFile toFile = new RandomAccessFile(FILE_DIR + "tmp_to",
				"rw");
		FileChannel toChannel = toFile.getChannel();
		long position = 0;
		long count = fromChannel.size();
		toChannel.transferFrom(fromChannel, position, count);
	}

	@Test
	public void testTransferTo() throws Exception {
		RandomAccessFile fromFile = new RandomAccessFile(FILE_DIR + "tmp", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		RandomAccessFile toFile = new RandomAccessFile(FILE_DIR + "tmp_to2",
				"rw");
		FileChannel toChannel = toFile.getChannel();
		long position = 0;
		long count = fromChannel.size();
		fromChannel.transferTo(position, count, toChannel);
	}

	/**
	 * FileChannel.truncate()方法截取一个文件。截取文件时，文件将中指定长度后面的部分将被删除。
	 * @throws Exception
	 */
	@Test
	public void testTruncate() throws Exception {
		RandomAccessFile file = new RandomAccessFile(FILE_DIR + "tmp_to", "rw");
		FileChannel channel = file.getChannel();
		channel.truncate(channel.size() /2);
		channel.close();
		file.close();
	}

}
