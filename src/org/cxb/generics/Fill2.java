package org.cxb.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T>{
	void add(T t);
}

public class Fill2 {
	public static <T> void fill(Addable<T> addable , 
			Class<? extends T> classToken , int size){
		for (int i = 0 ; i < size ; i++)
			try{
				addable.add(classToken.newInstance());
			}catch(Exception e){
				throw new RuntimeException();
			}
	}
	
	public static <T> void fill(Addable<T> addable , 
			Generator<? extends T> generator , int size){
		for (int i = 0 ; i < size ; i++)
			addable.add(generator.next());
	}
}

class AddableCollectionAdapter<T> implements Addable<T>{
	private Collection<T> c;
	public AddableCollectionAdapter(Collection<T> c){
		this.c = c;
	}
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		c.add(t);
	}
	
}

class Adapter{
	public static <T> 
	Addable<T> collectionAdapter(Collection<T> c){
		return new AddableCollectionAdapter<T>(c);
	}
}

class Fill2Test{
	public static void main(String[] args) {
		List<Coffee> carrier = new ArrayList<Coffee>();
		Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), 
				Coffee.class , 
				3);
		Fill2.fill(Adapter.collectionAdapter(carrier), 
				Latte.class , 
				2);
		for (Coffee c : carrier)
			System.out.println(c);
	}
}


