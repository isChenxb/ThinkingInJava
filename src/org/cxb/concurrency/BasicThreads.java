package org.cxb.concurrency;

public class BasicThreads {
	public static void main(String[] args) {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("It's main Thread!");
	}
}
