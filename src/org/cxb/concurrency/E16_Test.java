package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DualsynchDemo2 extends DualsynchDemo {
//	Object obj1 = new Object();
//	Object obj2 = new Object();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	private Lock lock3 = new ReentrantLock();
	public void method1() {
		lock1.lock();
		try {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method1()");
				Thread.yield();
			}
		}finally {
			lock1.unlock();
		}
	}
	
	public void method2() {
		lock2.lock();
		try {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method2()");
				Thread.yield();
			}
		}finally {
			lock2.unlock();
		}
	}
	
	public void method3() {
		lock3.lock();
		try {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method3()");
				Thread.yield();
			}
		}finally {
			lock3.unlock();
		}
	}
}

class Task01 implements Runnable {
	DualsynchDemo demo;
	public Task01(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method1();
	}
	
}

class Task02 implements Runnable {
	DualsynchDemo demo;
	public Task02(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method2();
	}
	
}


class Task03 implements Runnable {
	DualsynchDemo demo;
	public Task03(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method3();
	}
	
}

public class E16_Test {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		DualsynchDemo2 demo = new DualsynchDemo2();
		exec.execute(new Task01(demo));
		exec.execute(new Task02(demo));
		exec.execute(new Task03(demo));
		exec.shutdown();
	}
}
