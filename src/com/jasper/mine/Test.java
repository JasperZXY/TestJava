package com.jasper.mine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;
import java.util.regex.Matcher;
import com.sun.tools.javac.resources.compiler;
public class Test {
	public static void main(String[] args) {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("F:\\tmp\\uid.txt"));
			for(int i=0; i<1024*1024;i++) {
				writer.write("1");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Animal {
	public static void m() {
		System.out.println("animal");
	}
}
class Cat extends Animal {
	public static void m() {
		System.out.println("cat");
	}
}
