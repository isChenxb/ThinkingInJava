package org.cxb.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayWithTypeToken<T> {
	private T[] array;
	public GenericArrayWithTypeToken(Class<T> type , int sz){
		array = (T[])Array.newInstance(type , sz);
	}
	public void put(int index , T  item){
		array[index] = item;
	}
	public T get(int index){
		return array[index];
	}
	public T[] rep(){
		return array;
	}
	
	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> gen = 
				new GenericArrayWithTypeToken<Integer>(Integer.class , 10);
		gen.put(0, 1);
		System.out.println(gen.get(0));
		Integer[] arrayss = gen.rep();
		System.out.println(Arrays.toString(arrayss));
	}
}
