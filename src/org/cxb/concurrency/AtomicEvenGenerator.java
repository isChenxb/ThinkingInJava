package org.cxb.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
	private AtomicInteger i = new AtomicInteger(0);
	@Override
	public int next() {
		return i.addAndGet(2);
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new AtomicEvenGenerator());
	}
	
}
