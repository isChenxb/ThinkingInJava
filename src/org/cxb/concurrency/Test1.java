package org.cxb.concurrency;

class MyRunnable1 implements Runnable{
	private static int count = 0;
	private final int id = count++;
	private int times = 3;
	public MyRunnable1(){
		System.out.println("#" + id + "constructed...");
	}
	@Override
	public void run() {
		for(int i = 1 ; i <= times ; i++){
			System.out.println("#" + id + ": " + i);
			Thread.yield();
		}
		System.out.println("#" + id + " over...");
	}
	
}

public class Test1 {
	public static void main(String[] args) {
		for (int i = 0 ; i < 3 ; i++)
			new Thread(new MyRunnable1()).start();
	}
}
