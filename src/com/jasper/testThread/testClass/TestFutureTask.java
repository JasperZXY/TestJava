package com.jasper.testThread.testClass;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

	public static void main(String[] args) throws Exception {
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "hello";
			}
		});

		new Thread(task).start();

		System.out.println(task.get());

	}

}