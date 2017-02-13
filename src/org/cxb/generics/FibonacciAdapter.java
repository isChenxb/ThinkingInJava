package org.cxb.generics;

import java.util.Iterator;

public class FibonacciAdapter implements Iterable<Integer>{
	private Fibonacci fib = new Fibonacci();
	private int count;
	public FibonacciAdapter(int count){ this.count = count; } 
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return count > 0;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				count--;
				return fib.next();
			}
			
		};
	}
	
	public static void main(String[] args) {
		FibonacciAdapter fib = new FibonacciAdapter(18);
		for (Integer i : fib)
			System.out.print(i + " ");
	}
}
