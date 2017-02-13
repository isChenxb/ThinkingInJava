package org.cxb.generics;

import java.util.Iterator;
import java.util.Random;


public class CoffeeGenerator implements Generator<Coffee> , Iterable<Coffee>{
	private Class[] types = new Class[]{
		Breve.class , Latte.class , Mocha.class , Cappuccino.class , Americano.class
	};
	private static Random rand = new Random(47);
	private int size = 0;
	public CoffeeGenerator(){}
	public CoffeeGenerator(int size){ this.size = size; }
	
	@Override
	public Coffee next() {
		// TODO Auto-generated method stub
		try {
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count = size;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count > 0;
		}

		@Override
		public Coffee next() {
			// TODO Auto-generated method stub
			count--;
			return CoffeeGenerator.this.next();
		}
		
	};
	
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}
	
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0 ; i < 5 ; i++)
			System.out.println(gen.next());
		for (Coffee coffee : new CoffeeGenerator(5))
			System.out.println(coffee);
	}

}
