package org.cxb.generics;

class Generic<T>{}

public class ArrayOfGenericReference {
	static Generic<Integer>[] gia ;
	public static void main(String[] args) {
//		gia = (Generic<Integer>[])new Object[10];
		gia = (Generic<Integer>[])new Generic[10];
		System.out.println(gia.getClass().getSimpleName());
		System.out.println(gia[0]);
		gia[0] = new Generic();
		gia[1] = new Generic<Integer>();
//		gia[2] = new Generic<Double>();
	}
}
 