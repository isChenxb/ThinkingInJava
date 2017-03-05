package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
	private volatile boolean waxOn = false;

	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}

	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false)
			wait();
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn == true)
			wait();
	}
}

class WaxOn implements Runnable {
	private Car c;

	public WaxOn(Car c) {
		this.c = c;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("waxOn");
				TimeUnit.MICROSECONDS.sleep(200);
				c.waxed();
				c.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Existing via interrupt");
		}
		System.out.println("Ending wax on task");

	}
}

class WaxOff implements Runnable {
	private Car c;
	public WaxOff(Car c) { this.c = c; }
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				c.waitForWaxing();
				System.out.println("waxOff");
				TimeUnit.MILLISECONDS.sleep(200);
				c.buffed();
			}
		} catch(InterruptedException e) {
			System.out.println("Existing via interrupt");
		}
		System.out.println("Ending wax off task");
	}
}

public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Car c = new Car();
		exec.execute(new WaxOn(c));
		exec.execute(new WaxOff(c));
		exec.shutdown();
		TimeUnit.SECONDS.sleep(3);
		exec.shutdownNow();
	}
}
