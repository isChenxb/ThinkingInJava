package org.cxb.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenVal = 0;
	private Lock lock = new ReentrantLock();
	@Override
	public int next() {
		lock.lock();
		try{
			currentEvenVal++;
			Thread.yield();
			currentEvenVal++;
			return currentEvenVal;
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
