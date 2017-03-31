package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;

class TaskNeedInterrupt implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().isInterrupted());
			if (Thread.currentThread().isInterrupted()){
				System.out.println("isInterrupted");
				System.out.println(Thread.currentThread().isInterrupted());
				return;
			}
		}
	}
	
}

class SleepTask2 implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().isInterrupted());
		}
	}
}

class InterruptedTask implements Runnable {
	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println(true + "-----------------------------------");
				if (Thread.interrupted())
					System.out.println("isInterrupted()" + true);
			}
		}
	}
}

public class InterruptTest {
	public static void main(String[] args) throws Exception {
//		Thread thread = new Thread(new SleepTask2());
		Thread thread = new Thread(new InterruptedTask());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
}
