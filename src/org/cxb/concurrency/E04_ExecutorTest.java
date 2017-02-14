package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E04_ExecutorTest {
	public static void main(String[] args) {
//		ExecutorService exec = Executors.newCachedThreadPool();
//		ExecutorService exec = Executors.newFixedThreadPool(3);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 1 ; i <= 10 ; i++)
			exec.execute(new FibonacciRunnable(i));
		exec.shutdown();
	}
}
