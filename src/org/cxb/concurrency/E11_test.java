package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestClass {
	private int i1 = 0;
	private int i2 = 0;
	private volatile boolean error = false;
	
	public void doSomething() {
		i1++;
		i1++;
		i2 = i1 / 2;
	}
	
	public void error() {
		error = true;
	}
	
	public boolean isError() {
		return error;
	}
	
	public int getI1() {
		return i1;
	}
	
	public int getI2() {
		return i2;
	}
	
	public boolean check() {
		return getI1() / 2 != getI2();
	}
}

class SynchronizedTestClass extends TestClass {
	private int i1 = 0;
	private int i2 = 0;
	private volatile boolean error = false;
	@Override
	public synchronized void doSomething() {
		i1++;
		i1++;
		i2 = i1 / 2;
	}
	@Override
	public synchronized void error() {
		error = true;
	}
	@Override
	public synchronized boolean isError() {
		return error;
	}
	@Override
	public synchronized int getI1() {
		return i1;
	}
	
	public synchronized int getI2() {
		return i2;
	} 
	@Override
	public synchronized boolean check() {
		return getI1() / 2 != getI2();
	}
}



class ClassTask implements Runnable {
	private TestClass test;
	public ClassTask(TestClass test) {
		this.test = test;
	}
	@Override
	public void run() {
		while(!test.isError()){
			test.doSomething();
			if (test.check()){
				System.out.println("error happend");
				test.error();
			}
		}
	}
	
	public static void test(TestClass test , int count) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0 ; i < count ; i++)
			exec.execute(new ClassTask(test));
		exec.shutdown();
	}
	
	public static void test(TestClass test) {
		test(test , 10);
	}
	
}

public class E11_test {
	public static void main(String[] args) {
//		ClassTask.test(new TestClass());
		ClassTask.test(new SynchronizedTestClass());
	}
}
