package org.cxb.arrays;

import java.util.Arrays;
import java.util.Comparator;

import net.mindview.util.Generated;

class CompTypeComparator implements Comparator<CompType>{

	@Override
	public int compare(CompType o1, CompType o2) {
		// TODO Auto-generated method stub
		return (o1.j < o2.j ? -1 : (o1.j == o2.j) ? 0 : 1);
	}
	
}

public class ComparatorTest {
	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[10], 
				CompType.generator());
		System.out.println("before sort : ");
		System.out.println(Arrays.toString(a));
		Arrays.sort(a , new CompTypeComparator());
		System.out.println("after sort : ");
		System.out.println(Arrays.toString(a));
	}
}
