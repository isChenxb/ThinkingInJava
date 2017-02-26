package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LongTask implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("Task over");
		} catch(InterruptedException e) {
			System.out.println("interrupted!");
		}
	}
}

public class AwaitTerminationTest {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new LongTask());
		exec.shutdown();
		if (!exec.awaitTermination(2, TimeUnit.SECONDS))
			System.out.println("Task is Running");
	}
}
