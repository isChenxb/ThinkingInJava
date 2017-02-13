package org.cxb.generics;

public class Fibonacci implements Generator<Integer>{
	private int count = 0;
	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(count++);
	}
	
	private int fib(int n){
		if (n < 2)
			return 1;
		return fib(n - 1) + fib(n -2);
	}
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		for (int i = 0 ; i < 18 ; i++)
			System.out.print(fib.next() + " ");
	}

}
