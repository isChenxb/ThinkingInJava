package org.cxb.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AssociativeArray<K , V> {
	private Object[][] pairs;
	private int index;
	public AssociativeArray(int length){
		pairs = new Object[length][2];
	}
	public void put(K key , V value){
		if (index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		for (int i = 0 ; i < index ; i++)
			if (key.equals(pairs[i][0])){
				pairs[i][1] = value;
				return;
			}
		pairs[index++] = new Object[]{key , value};
	}
	@SuppressWarnings("unchecked")
	public V get(K key){
		for (int i = 0 ; i < index ; i++)
			if (pairs[i][0].equals(key))
				return (V)pairs[i][1];
		return null;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < index ; i++){
			sb.append(pairs[i][0].toString());
			sb.append(" : ");
			sb.append(pairs[i][1].toString());
			if (i < index - 1)
				sb.append("\n");
		}
		return sb.toString();
	}
	
	/* util methods */
	public void checkForNull(Object o){
		if (o == null)
			throw new NullPointerException();
	}
	
	public static void main(String[] args) {
		Map<String , String> map = 
				new LinkedHashMap<String , String>();
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try{
			map.put("extra", "object");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Too many objects");
		}
		System.out.println(map);
		System.out.println(map.get("ocean"));
	}
}
