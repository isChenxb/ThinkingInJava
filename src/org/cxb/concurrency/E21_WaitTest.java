package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WaitTask implements Runnable {
	public WaitTask() {
		System.out.println("WaitTask constructed");
	}
	@Override
	public void run() {
		synchronized(this) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("WaitTask is interrupted");
			}
			System.out.println("print things");
		}
	}
}

class NotifyTask implements Runnable {
	Runnable anotherTask;
	public NotifyTask(Runnable task) {
		anotherTask = task;
	}
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			System.out.println("NotifyTask interrupted");
		}
		synchronized(anotherTask) {
			anotherTask.notifyAll();
		}
	}
}

public class E21_WaitTest {
	public static void main(String[] args) {
		Runnable wait = new WaitTask();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(wait);
		exec.execute(new NotifyTask(wait));
		exec.shutdown();
	}
}
