package org.cxb.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(
				Arrays.asList(new Integer[]{
						1 , 2 
				})); 
		System.out.println(list);
//		list.remove(1);
		list.remove(1);
		System.out.println(list);
	}
}
