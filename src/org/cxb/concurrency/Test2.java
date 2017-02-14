package org.cxb.concurrency;

import java.util.Arrays;

class FibonacciRunnable implements Runnable{
	private int n;
	public FibonacciRunnable(int n){
		this.n = n;
	}
	private int fibonacci(int num){
		if (num < 0)
			throw new IllegalArgumentException();
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		return fibonacci(num - 1) + fibonacci(num - 2);
	}
	@Override
	public void run() {
		int[] fib = new int[n];
		for (int i = 0 ; i < fib.length ; i++){
			fib[i] = fibonacci(i);
		}
		System.out.println("fib#" + n + "= " + Arrays.toString(fib));
	}
}

public class Test2 {
	public static void main(String[] args) {
		for(int i = 1 ; i <= 10 ; i++)
			new Thread(new FibonacciRunnable(i)).start();
	}
}
