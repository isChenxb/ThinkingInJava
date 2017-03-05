package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;

class NeedCleanup {
	private final int id;
	public NeedCleanup(int ident) {
		id = ident;
		System.out.println("NeedCleanup " + id);
	}
	
	public void cleanup() {
		System.out.println("Clean up " + id);
	}
	
}

class Blocked3 implements Runnable {
	private volatile double d = 0.0;
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				//point1
				NeedCleanup n1 = new NeedCleanup(1);
				try {
					System.out.println("sleeping");
					TimeUnit.SECONDS.sleep(1);
					//point2
					NeedCleanup n2 = new NeedCleanup(2);
					try {
						System.out.println("calculating");
						for (int i = 1 ; i < 2500000 ; i++)
							d = d + (Math.PI + Math.E) / d;
						System.out.println("finished time-consuming operation");
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
//			System.out.println(Thread.interrupted());
			System.out.println("out while");
		} catch (InterruptedException e) {
			System.out.println("exiting interrupException");
		}
	}
}

public class InterruptingIdiom {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(1030);
		t.interrupt();
	}
}
