package org.cxb.arrays;

import java.util.Arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

public class PrimitiveConversionDemonstration {
	public static void main(String[] args) {
		Integer[] a = Generated.array(Integer.class, new RandomGenerator.Integer(), 10);
		int[] b = ConvertTo.primitive(a);
		System.out.println(Arrays.toString(b));
	}
}
