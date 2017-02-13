package org.cxb.containers;

import java.util.Map;
import java.util.Properties;

import net.mindview.util.CountingMapData;

public class Maps {
	public static void printKeys(Map<Integer , String> map){
		System.out.print("Size = " + map.size() + " , ");
		System.out.print("Keys: ");
		System.out.println(map.keySet());
	}
	
	public static void test(Map<Integer , String> map){
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		//Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(25));
		printKeys(map);
		//producing a Collection of the values:
		System.out.print("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): " + map.containsKey(11));
		System.out.println("map.get(11): " + map.get(11));
		System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
		Object key = map.keySet().iterator().next();
		System.out.println("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		//operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): " + map.isEmpty());
		
	}
	
	public static void main(String[] args) {
		test(new SlowMap2<Integer , String>());
//		test(new Properties());
//		test(new HashMap<Integer , String>());
//		test(new TreeMap<Integer , String>());
//		test(new LinkedHashMap<Integer , String>());
//		test(new IdentityHashMap<Integer , String>());
//		test(new ConcurrentHashMap<Integer , String>());
//		test(new WeakHashMap<Integer , String>());
//		Map<Integer , String> map = new IdentityHashMap<Integer , String>();
//		map.put(5, new String("F0"));
//		System.out.println(map.containsValue("F0"));
	}
}
