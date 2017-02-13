package org.cxb.containers;

import java.util.Map;

public class E25_FullSimpleHashMap {
	public static void main(String[] args) {
		Map<String , String> map = 
				new SimpleHashMap3<String , String>() , 
		map2 = new SimpleHashMap3<String , String>();
		map.putAll(Countries.capitals(10));
		map2.putAll(Countries.capitals(10));
		System.out.println("map.size() = " + map.size());
		System.out.println("map.isEmpty() = " + map.isEmpty());
		System.out.println("map.equals(map2) " + map.equals(map2));
		System.out.println("map.containsKey(\"BENIN\") = " +
		  map.containsKey("BENIN"));
		System.out.println("map.containsKey(\"MARS\") = " +
				  map.containsKey("MARS"));
		System.out.println("map.keySet() = " + map.keySet());
		System.out.println("map.values() = " + map.values());
		System.out.println("m = " + map);
		map.remove("ALGERIA");
		System.out.println("m = " + map);
	}
}
