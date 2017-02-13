package org.cxb.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Test7 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(Countries.names(10));
		List<String> list2 = new LinkedList<String>(Countries.names(10));
		Iterator<String> it1 = list1.iterator();
		Iterator<String> it2 = list2.iterator();
		while(it1.hasNext())
			System.out.print(it1.next() + " ");
		System.out.println("");
		while(it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println("");
		ListIterator<String> it3 = list1.listIterator();
		ListIterator<String> it4 = list2.listIterator();
		while(it3.hasNext()){
			it3.next();
			it3.add(it4.next());
		}
		System.out.println(list1);
	}
}
