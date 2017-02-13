package org.cxb.arrays;

import java.util.Arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

public class TestGGenerated {
	public static void main(String[] args) {
		Integer[] a = { 1 , 2 , 3 , 4 };
		System.out.println(Arrays.toString(a));
		a = Generated.array(a, new RandomGenerator.Integer());
		System.out.println(Arrays.toString(a));
		Integer[] b = Generated.array(Integer.class, new RandomGenerator.Integer(), 10);
		System.out.println(Arrays.toString(b));
	}
}
