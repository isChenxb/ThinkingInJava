package org.cxb.containers;

import org.cxb.io.TextFile;

public class E13_MapTest {
	public static void main(String[] args) {
//		AssociativeArray<String , Integer> map = 
//				new AssociativeArray<String , Integer>(100);
		SlowMap<String , Integer> map = new SlowMap<String , Integer>();
		TextFile textFile = new TextFile("test2.txt" , "\\W+");
		for (String item : textFile){
			Integer value ;
			if ((value = map.get(item)) != null)
				map.put(item , value + 1);
			else
				map.put(item, 1);
		}
		System.out.println(map);
		System.out.println(map.hashCode());
	}
}
