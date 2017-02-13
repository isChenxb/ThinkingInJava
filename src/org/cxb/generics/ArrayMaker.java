package org.cxb.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
	private Class<T> kind;
	public ArrayMaker(Class<T> kind){
		this.kind = kind;
	}
	T[] create(int size){
		System.out.println(kind.getClass().getSimpleName());
		return (T[]) Array.newInstance(kind, size);
	}
	
	public static void main(String[] args) {
		ArrayMaker<String> stringMaker = 
				new ArrayMaker<String>(String.class);
		String[] stringArray = stringMaker.create(9);
		System.out.println(Arrays.toString(stringArray));
		Integer[] ints = (Integer[]) Array.newInstance(Integer.class, 9);
		System.out.println(Arrays.toString(ints));
		String[] strs = new String[9];
		ints = new Integer[9];
		int[] intss = new int[9];
		System.out.println(Arrays.toString(strs));
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(intss));
	}
}
