package com.jasper.mine;

import java.util.HashSet;
import java.util.Set;

public class TestMemoryUse {
	private static final Runtime s_runtime = Runtime.getRuntime();

	public static void main(String[] args) throws Exception {
		// 垃圾回收
		runGC();

		// 实例化前堆已使用大小
		long start = usedMemory();

		// Object object = new Object(); // 16
		// Integer integer = new Integer(1); //196
		Set<Object> set = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			set.add(new Object());
		}

		runGC();
		// 实例化之后堆已使用大小
		long end = usedMemory();
		final long size = end - start;
		System.out.println(size);
	}

	// runGC()可以帮我们真正的确定完成垃圾收集(准确的说，应该说是基本上完成)。
	private static void runGC() throws Exception {
		// 执行多次以使内存收集更有效
		for (int r = 0; r < 4; ++r) {
			_runGC();
		}
	}

	private static void _runGC() throws Exception {
		long usedMem1 = usedMemory();
		long usedMem2 = Long.MAX_VALUE;
		for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i) {
			s_runtime.runFinalization();
			s_runtime.gc();
			Thread.currentThread().yield();
			usedMem2 = usedMem1;
			usedMem1 = usedMemory();
		}
	}

	/**
	 * 
	 * 堆中已使用内存
	 * 
	 * @return 堆中已使用内存
	 */
	private static long usedMemory() {
		return s_runtime.totalMemory() - s_runtime.freeMemory();
	}

}
