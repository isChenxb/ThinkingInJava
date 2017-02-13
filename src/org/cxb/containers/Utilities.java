package org.cxb.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Utilities {
	static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

	public static void main(String[] args) throws Exception {
		System.out.println(list);
		System.out.println("'list' disjoint(four) : " + 
		      Collections.disjoint(list, 
		    		  Collections.singletonList("four")));
		System.out.println("max : " + Collections.max(list));
		System.out.println("min : " + Collections.min(list));
		System.out.println("max w/ comparator: " + Collections.max(list , 
				String.CASE_INSENSITIVE_ORDER));
		System.out.println("min w/ comparator: " + Collections.min(list , 
				String.CASE_INSENSITIVE_ORDER));
		List<String> sublist = 
				Arrays.asList("Four five six".split(" "));
		System.out.println("indexOfSubList : " + 
				Collections.indexOfSubList(list, sublist));
		System.out.println("lastIndexOfSubList : " + 
				Collections.lastIndexOfSubList(list, sublist));
		Collections.replaceAll(list, "one", "yo");
		System.out.println("replaceAll: " + list);
		Collections.reverse(list);
		System.out.println("reverse : " + list);
		Collections.rotate(list, 3);
		System.out.println("rotate : " + list);
		List<String> source = 
				Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		System.out.println("copy : " + list);
		Collections.swap(list, 0, list.size() - 1);
		System.out.println("swap : " + list);
		Collections.shuffle(list , new Random(47));
		System.out.println("shuffle : " + list);
		Collections.fill(list, "pop");
		System.out.println("fill : " + list);
		System.out.println("frequency of 'pop': " + Collections.frequency(list, "pop"));
		List<String> dups = Collections.nCopies(3, "snap");
		System.out.println("dups : " + dups);
		System.out.println("'list' disjoint 'dups' ?: " + Collections.disjoint(list, dups));
		Enumeration<String> e = Collections.enumeration(dups);
		Vector<String> v = new Vector<String>();
		while(e.hasMoreElements())
			v.addElement(e.nextElement());
		ArrayList<String> arrayList = 
				Collections.list(v.elements());
		System.out.println("arrayList : " + arrayList);
	}
}
