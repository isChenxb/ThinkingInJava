package org.cxb.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Generators {
	public static <T> Collection<T> 
	fill(Collection<T> coll , Generator<T> gen , int length){
		for (int i = 0 ; i < length ; i++)
			coll.add(gen.next());
		return coll;
	}
	
	public static <T> ArrayList<T>
	fill(ArrayList<T> coll , Generator<T> gen , int length){
		for (int i = 0 ; i < length ; i++)
			coll.add(gen.next());
		return coll;
	}
	
	
	
	public static <T> LinkedList<T>
	fill(LinkedList<T> coll , Generator<T> gen , int length){
		for (int i = 0 ; i < length ; i++)
			coll.add(gen.next());
		return coll;
	}
	
	public static void main(String[] args) {
		ArrayList<Coffee> coffee = 
				fill(new ArrayList<Coffee>() , new CoffeeGenerator() , 10);
		for(Coffee coff : coffee)
			System.out.println(coff);
		Collection<Integer> fibs = 
				fill(new ArrayList<Integer>() , new Fibonacci() , 10);
		for(Integer i : fibs)
			System.out.print(i+" ");
	}
}
