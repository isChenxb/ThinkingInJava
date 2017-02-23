package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DualsynchDemo {
	Object obj1 = new Object();
	Object obj2 = new Object();
	public void method1() {
		synchronized (this) {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method1()");
				Thread.yield();
			}
		}
	}
	
	public void method2() {
		synchronized (obj1) {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method2()");
				Thread.yield();
			}
		}
	}
	
	public void method3() {
		synchronized (obj2) {
			for (int i = 0 ; i < 10 ; i++){
				System.out.println("method3()");
				Thread.yield();
			}
		}
	}
}

class Task1 implements Runnable {
	DualsynchDemo demo;
	public Task1(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method1();
	}
	
}

class Task2 implements Runnable {
	DualsynchDemo demo;
	public Task2(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method2();
	}
	
}


class Task3 implements Runnable {
	DualsynchDemo demo;
	public Task3(DualsynchDemo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		demo.method3();
	}
	
}

public class E15_Test {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		DualsynchDemo demo = new DualsynchDemo();
		exec.execute(new Task1(demo));
		exec.execute(new Task2(demo));
		exec.execute(new Task3(demo));
		exec.shutdown();
	}
}
