package org.cxb.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException!");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}
}

class IOBlocked implements Runnable {
	private InputStream is;
	public IOBlocked(InputStream is) {
		this.is = is;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting for read()");
			is.read();
		} catch (IOException e) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted from blocked IO");
			} else {
				throw new RuntimeException();
			}
		}
		System.out.println("Exiting IOBlocked.run()");
	}
}

class SynchronizedBlocked implements Runnable {
	public SynchronizedBlocked() {
		new Thread() {
			@Override
			public void run() {
				f();
			}
		}.start();
	}
	public synchronized void f() {
		while(true) {
			Thread.yield();
		}
	}
	
	@Override
	public void run() {
		System.out.println("try to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
}

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	public static void test(Runnable task) throws InterruptedException {
		Future<?> future = exec.submit(task);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrpting " + task.getClass().getSimpleName());
		future.cancel(true);
		System.out.println("Interrupt sent to " + task.getClass().getSimpleName());
	}
	
	public static void main(String[] args) throws Exception{
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}
}
