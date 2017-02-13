package org.cxb.containers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Test3 {
	public static void main(String[] args) {
		
		
		Set<String> set = new TreeSet<String>();
		for (int i = 0 ; i < 10 ; i++)
			set.addAll(Countries.names(10));
		System.out.println(set);
	}
}
