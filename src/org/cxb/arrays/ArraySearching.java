package org.cxb.arrays;

import java.util.Arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

public class ArraySearching {
	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer();
		Integer[] a = Generated.array(new Integer[20], 
				gen);
		Arrays.sort(a);
		System.out.println("sort array : ");
		System.out.println(Arrays.toString(a));
		while(true){
			int r = gen.next();
			int location = Arrays.binarySearch(a, r);
			if (location >= 0){
				System.out.println("the " + r + " location is " + location);
				break;
			}
		}
	}
}
