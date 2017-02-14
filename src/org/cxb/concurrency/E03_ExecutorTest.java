package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03_ExecutorTest {
	public static void main(String[] args) {
//		ExecutorService exec = Executors.newCachedThreadPool();
//		ExecutorService exec = Executors.newFixedThreadPool(3);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0 ; i < 6 ; i++)
			exec.execute(new MyRunnable1());
		exec.shutdown();
	}
}
