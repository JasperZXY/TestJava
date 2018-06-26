package com.zxy.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

public class PathAndFile {
	@Test
	public void testPath() {
		Path path = Paths.get("F:\\\\tmp\\person.xml");
		System.out.println("AbsolutePath:" + path.toAbsolutePath());
		System.out.println("uri" + path.toUri());
		System.out.println("parent:" + path.getParent());
		System.out.println("root:" + path.getRoot());
		System.out.println("fileName:" + path.getFileName());
		System.out.println("nameCount:" + path.getNameCount());
		System.out.println("subPath:" + path.subpath(0, 2));
		
		System.out.println(Paths.get("/1/2/3/4/5.abc").getNameCount());
		System.out.println(Paths.get("./1/2/3/4/5.abc").normalize());

		Path dir = Paths.get("F:\\\\tmp");
		Path log = Paths.get("logs\\log.log");
		System.out.println(dir.resolve(log));   //拼接
		System.out.println(dir.resolve(log).startsWith(dir));
		System.out.println(dir.resolve(log).relativize(dir)); //返回相对路径
		
		System.out.println("toFile:" + dir.toFile());
	}
	
	@Test
	public void testDir() {
		Path dir = Paths.get("F:\\\\tmp");
		
		//这个只能列出当前目录下符合的文件
		try (DirectoryStream<Path> stream = 
				Files.newDirectoryStream(dir, "*.txt")) {
			System.out.println("=========DirectoryStream start=========");
			for (Path path : stream) {
				System.out.println(path);
			}
			System.out.println("=========DirectoryStream end=========");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//这个将递归列出所有符合的文件
		try {
			System.out.println("=========walkFileTree start=========");
			Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
				@Override
			    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
					if (path.toString().endsWith(".txt")) {
						System.out.println(path);
					}
					return FileVisitResult.CONTINUE;
				}
			});
			System.out.println("=========walkFileTree end=========");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFile() {
		Path target = Paths.get("F:\\\\tmp\\new_file");
		try {
			Files.createFile(target);
			System.out.println(target.toFile().exists());
			Files.delete(target);
			System.out.println(target.toFile().exists());
			
//			Files.copy(Paths.get("F:\\\\tmp\\from.txt"), Paths.get("F:\\\\tmp\\to.txt"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(Files.readAllLines(Paths.get("F:\\\\tmp\\a.txt"), Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(Files.readAttributes(Paths.get("F:\\\\tmp\\a.txt"), "*"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFileChannel() {
		Path path = Paths.get("F:\\\\tmp\\big.txt");
		ByteBuffer buffer = ByteBuffer.allocate(9);
		try {
			FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
			//读取最后的9个字节
			fileChannel.read(buffer, fileChannel.size() - 9);
			System.out.println(new String(buffer.array()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
