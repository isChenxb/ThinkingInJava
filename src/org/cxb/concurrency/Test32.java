package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Entrance3 implements Runnable {
	private static Count count = new Count();
	private static List<Entrance3> entrances = 
			new ArrayList<Entrance3>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	private final CountDownLatch latch;
	public static void cancel() {
		canceled = true;
	}
	public Entrance3(int id , CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
		entrances.add(this);
	}
	@Override
	public void run() {
		while(!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch(InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
		latch.countDown();
		System.out.println("Stopping " + this);
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
		for (Entrance3 entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}
	
}

public class Test32 {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0 ; i < 5 ; i++) 
			exec.execute(new Entrance3(i , latch));
		TimeUnit.SECONDS.sleep(3);
		Entrance3.cancel();
		exec.shutdown();
		latch.await();
//		if (!exec.awaitTermination(250 , TimeUnit.MILLISECONDS))
//			System.out.println("Some tasks were not terminated!");
		System.out.println("Total: " + Entrance3.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance3.sumEntrances());
	}
}
