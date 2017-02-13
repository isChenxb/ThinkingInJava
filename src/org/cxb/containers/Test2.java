package org.cxb.containers;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test2 {
	public static void main(String[] args) {
		TreeMap<String , String> map = 
				new TreeMap<String , String>(Countries.capitals());
		TreeSet<String> set = new TreeSet<String>(Countries.names);
		String b = "";
		for (String s : map.keySet())
			if (s.startsWith("B")){
				b = s;
				break;
			}
		Map<String , String> aMap = map.headMap(b);
		Set<String> aSet = set.headSet(b);
		System.out.println("aMap : " + aMap);
		System.out.println("aSet : " + aSet);
	}
}
