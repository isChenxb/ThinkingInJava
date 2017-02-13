package org.cxb.generics;

import java.util.Arrays;

public class Test26 {
	public static void main(String[] args) {
		Number[] array = new Integer[10];
		array[0] = new Integer(1);
//		array[1] = new Number();
		array[1] = new Float(1.0f);
		System.out.println(Arrays.toString(array));
	}
}
