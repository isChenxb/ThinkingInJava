package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Entrance2 implements Runnable {
	private static Count count = new Count();
	private static List<Entrance2> entrances = 
			new ArrayList<Entrance2>();
	private int number = 0;
	private final int id;
//	private static volatile boolean canceled = false;
//	public static void cancel() {
//		canceled = true;
//	}
	public Entrance2(int id) {
		this.id = id;
		entrances.add(this);
	}
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Stop " + this);
				return;
			}
		}
//		System.out.println("Stopping " + this);
	}
	public synchronized int getValue() {
		return number;
	}
	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}
	public static int getTotalCount() {
		return count.value();
	}
	public static int sumEntrances() {
		int sum = 0;
		for (Entrance2 entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}
	
}

public class E19_Test {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0 ; i < 5 ; i++) 
			exec.execute(new Entrance2(i));
		TimeUnit.SECONDS.sleep(3);
		exec.shutdown();
		exec.shutdownNow();
		if (!exec.awaitTermination(250 , TimeUnit.MILLISECONDS))
			System.out.println("Some tasks were not terminated!");
		System.out.println("Total: " + Entrance2.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance2.sumEntrances());
	}
}
