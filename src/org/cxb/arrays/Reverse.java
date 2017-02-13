package org.cxb.arrays;

import java.util.Arrays;
import java.util.Collections;

import net.mindview.util.Generated;

public class Reverse {
	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[10],
				CompType.generator());
		System.out.println("before sort : ");
		System.out.println(Arrays.toString(a));
		Arrays.sort(a , Collections.reverseOrder());
		System.out.println("after sort : ");
		System.out.println(Arrays.toString(a));
	}
}
