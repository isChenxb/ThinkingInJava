package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
	private Lock lock = new ReentrantLock();
	public void untimed() {
		boolean captured = lock.tryLock();
		try{
			System.out.println("tryLock() = " + captured);
		}finally {
			if (captured)
				lock.unlock();
		}
	}
	
	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
			throw new InterruptedException();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			System.out.println("tryLock(2 , TimeUnit.SECONDS) = " + captured);
		}finally {
			if (captured)
				lock.unlock();
		}
	}
	
	public static void main(String[] args) throws Exception{
		final AttemptLocking lock = new AttemptLocking();
		lock.untimed();
		lock.timed();
		Thread t = new Thread() {
			{ setDaemon(true); }
			@Override
			public void run() {
				lock.lock.lock();
				System.out.println("acquired");
			};
		};
		t.start();
//		Thread.yield();
		Thread.sleep(1000);
		lock.untimed();
		System.out.println(t.isAlive());
		lock.timed();
	}
}
