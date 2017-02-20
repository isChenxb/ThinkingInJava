package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator generator , int identy) {
		this.generator = generator;
		id = identy;
	}
	@Override
	public void run() {
		while(!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0){
				System.out.println(val + " not even!");
				generator.cancle();
			}
		}
	}
	
	public static void test(IntGenerator gen , int count) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0 ; i < count ; i++) {
			exec.execute(new EvenChecker(gen , i));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator gen) {
		test(gen , 10);
	}
	
}
