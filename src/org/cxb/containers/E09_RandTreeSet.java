package org.cxb.containers;

import java.util.SortedSet;
import java.util.TreeSet;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

public class E09_RandTreeSet {
	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		sortedSet.addAll(CollectionData.list(
				new RandomGenerator.String() , 10));
		System.out.println(sortedSet);
	}
}
