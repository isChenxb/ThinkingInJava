package org.cxb.arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

public class CopyingArrays {
	public static void main(String[] args) {
		Integer[] a = Generated.array(Integer.class, 
				new RandomGenerator.Integer(), 
				1000000);
		Integer[] b = Generated.array(Integer.class , 
				new RandomGenerator.Integer(),
				1000000);
		Integer[] a2 = new Integer[1000000];
		Integer[] b2 = new Integer[1000000];
		long aStart = System.nanoTime();
		for (int i = 0 ; i < a.length ; i++)
			a2[i] = a[i];
		System.out.println(System.nanoTime() - aStart);
		long bStart = System.nanoTime();
		System.arraycopy(b, 0, b2, 0, 1000000);
		System.out.println(System.nanoTime() - bStart);
	}
}
