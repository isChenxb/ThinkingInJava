package org.cxb.containers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;

class Government implements Generator<String>{
	String[] foundation = ("strange women lying in ponds "
			+ "distributing swords is no basis for a system of "
			+ "government").split(" ");
	private int index;
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundation[(index++) % foundation.length];
	}
	
}

public class CollectionDataTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(
				new CollectionData<String>(new Government() , 10));
		System.out.println(set);
		set.addAll(new CollectionData<String>(new Government() , 15));
		System.out.println(set);
		List<String> list = new ArrayList<String>(new CollectionData<String>(
				new Government() , 10));
		System.out.println(list);
		list.addAll(new CollectionData<String>(new Government() , 5));
		System.out.println(list);
	}
}
