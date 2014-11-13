package com.jasper.io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 从下面运行的结果可以看出
 * <ol>
 * <li>没有关闭流，将导致文件里面没有数据</li>
 * <li>有嵌套时，关闭流要按打开的顺序逆着来</li>
 * </ol>
 */
public class TestClose {
	private final static int N = 100;
	
	@Test
	public void noClose() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_no");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void closeStream() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_stream");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n" + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(os);
		}
	}
	
	@Test
	public void closeBuffer() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_buffer");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw);
		}
	}
	
	@Test
	public void closeWrite() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_write");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw);
		}
	}
	
	@Test
	public void closeAll() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_all");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw);
			close(osw);
			close(os);
		}
	}
	
	/**
	 * 逆序关闭
	 */
	@Test
	public void closeAllReversed() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + "/file/close_all_rev");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			for (int i=0; i<N; i++) {
				bw.write(String.valueOf(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(os);
			close(osw);
			close(bw);
		}
	}
	
	private void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
