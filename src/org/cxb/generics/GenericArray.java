package org.cxb.generics;

public class GenericArray<T> {
	private T[] array;
	public GenericArray(int size){
		array = (T[])new Object[size];
	}
	public void put(int index , T item){
		array[index] = item;
	}
	public T get(int index){
		return array[index];
	}
	public T[] rep(){
		return array;
	}
	
	public static void main(String[] args) {
		GenericArray<Integer> gen =
				new GenericArray<Integer>(10);
//		Integer[] array = (Integer[])new Object[10];
//		Object[] it = gen.rep();
		gen.put(0 , 1);
		System.out.println(gen.get(0));
	}
}
