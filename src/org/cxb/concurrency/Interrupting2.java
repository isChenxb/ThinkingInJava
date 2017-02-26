package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex {
	private Lock lock = new ReentrantLock();
	public BlockedMutex() {
		lock.lock();
		System.out.println(Thread.currentThread());
	}
	public void f() {
		try {
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch (InterruptedException e) {
			System.out.println("interrupted from lock acquisition in f()");
		}
	}
}

class Blocked2 implements Runnable {
	private BlockedMutex block = new BlockedMutex();
	@Override
	public void run() {
		System.out.println("Waiting for f() in BlockedMutex");
		block.f();
		System.out.println("Broken out of blocked call");
	}
	
}

public class Interrupting2 {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
//		System.out.println("Issuing t.interrupted");
		t.interrupt();
	}
}
