package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FibonacciCallable implements Callable<Integer>{
	private int num;
	public FibonacciCallable(int num){
		this.num = num;
	}
	
	private int fibonacci(int n){
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0 ; i < num ; i++)
			sum += fibonacci(i);
		return sum;
	}
}

public class E05_CallableFibonacci {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> futures = 
				new ArrayList<Future<Integer>>();
		for (int i = 1 ; i < 10 ; i++)
			futures.add(exec.submit(new FibonacciCallable(i)));
		exec.shutdown();
		int i = 0;
		while(!futures.isEmpty()){
			Future<Integer> future = futures.get(i % futures.size());
			if (future.isDone()){
				try {
					System.out.println(future.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				futures.remove(future);
				continue;
			}
			i++;
		}
	}
}
