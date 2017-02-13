package org.cxb.containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K , V> extends AbstractMap<K , V> {
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K , V>>[] buckets = 
			new LinkedList[SIZE];
	public V put(K key , V value){
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K , V>>();
		LinkedList<MapEntry<K , V>> bucket = buckets[index];
		MapEntry<K , V> pair = new MapEntry<K , V>(key , value);
		ListIterator<MapEntry<K , V>> it = bucket.listIterator();
		boolean found = false;
		while(it.hasNext()){
			MapEntry<K , V> item = it.next();
			if (item.getKey().equals(key)){
				oldValue = item.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if (!found)
			buckets[index].add(pair);
		return oldValue;
	}
	public V get(Object key){
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) return null;
		for (MapEntry<K , V> item : buckets[index])
			if (item.getKey().equals(key))
				return item.getValue();
		return null;
	}
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K , V>>();
		for (LinkedList<MapEntry<K , V>> bucket : buckets){
			if (bucket == null) continue;
			for(MapEntry<K , V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}
	
	public static void main(String[] args) {
		SimpleHashMap<String , String> m = 
				new SimpleHashMap<String , String>();
		m.putAll(Countries.capitals(25));
		System.out.println(m);
		System.out.println(m.get("ERITREA"));
		System.out.println(m.entrySet());
	}
	
}
