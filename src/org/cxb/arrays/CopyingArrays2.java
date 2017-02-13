package org.cxb.arrays;

import java.util.Arrays;

public class CopyingArrays2 {
	public static void main(String[] args) {
		int[] i = new int[7];
		int[] j = new int[10];
		Arrays.fill(i , 47);
		Arrays.fill(j , 99);
		System.out.println("i = " + Arrays.toString(i));
		System.out.println("j = " + Arrays.toString(j));
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j = " + Arrays.toString(j));
		int[] k = new int[5];
//		test(k);
	}
	
//	public static void test(Object obj){
//		System.out.println("haha");
//		System.out.println(obj);
//	}
	
	public static void test(Object[] obj){
		System.out.println("hehe");
	}
}
