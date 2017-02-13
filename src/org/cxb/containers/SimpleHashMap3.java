package org.cxb.containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap3<K , V> extends AbstractMap<K , V>{
	static class Entry<K , V> implements Map.Entry<K, V>{
		private K key;
		private V value;
		Entry<K , V> next;
		public Entry(K key , V value){
			this.key = key;
			this.value = value;
		}
		@Override
		public K getKey() {
			return key;
		}
		@Override
		public V getValue() {
			return value;
		}
		@Override
		public V setValue(V v) {
			V result = value;
			value = v;
			return result;
		}
		public int hashCode() {
		    return (key==null ? 0 : key.hashCode()) ^
		      (value==null ? 0 : value.hashCode());
		  }
		  public boolean equals(Object o) {
		    if(!(o instanceof MapEntry)) return false;
		    MapEntry me = (MapEntry)o;
		    return
		      (key == null ?
		       me.getKey() == null : key.equals(me.getKey())) &&
		      (value == null ?
		       me.getValue()== null : value.equals(me.getValue()));
		  }
		  public String toString() { return key + "=" + value; }
	}
	
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	private Entry<K , V>[] buckets = new Entry[SIZE];
	
//	@Override
//	public V put(K key, V value) {
//		V oldValue = null;
//		int index = Math.abs(key.hashCode()) % SIZE;
//		Entry<K , V> newPair = new Entry<K , V>(key , value);
//		if (buckets[index] == null)
//			buckets[index] = newPair;
//		Entry<K , V> prevPair = null;
//		boolean found = false;
//		for (Entry<K , V> pair = buckets[index] ; pair != null ; pair = pair.next){
//			if (pair.getKey().equals(key)){
//				oldValue = pair.getValue();
//				if (prevPair != null)
//					prevPair.next = newPair;
//				else
//					buckets[index] = newPair;
//				newPair.next = pair.next;
//				found = true;
//				break;
//			}
//			prevPair = pair;
//		}
//		if(!found)
//			prevPair.next = newPair;
//		return oldValue;
//	}
	
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		Entry<K , V> newPair = new Entry<K , V>(key , value);
		if (buckets[index] == null)
			buckets[index] = newPair;
		else{
			Entry<K , V> prevPair = null;
			boolean found = false;
			for (Entry<K , V> entry = buckets[index] ; entry != null ; entry = entry.next){
				if (entry.key.equals(key)){
					found = true;
					oldValue = entry.getValue();
					newPair.next = entry.next;
					if (prevPair == null)
						buckets[index] = newPair;
					else
						prevPair.next = newPair;
					break;
				}
				prevPair = entry;
			}
			if (!found)
				prevPair.next = newPair;
		}
		return oldValue;
	}
	@Override
	public V get(Object key){
		int index = Math.abs(key.hashCode()) % SIZE;
		for (Entry<K , V> entry = buckets[index] ; entry != null ; entry = entry.next)
			if (entry.getKey().equals(key))
				return entry.getValue();
		return null;
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K , V>>();
		for (Entry<K , V> bucket : buckets){
			for (Entry<K , V> pair = bucket ; pair != null ; pair = pair.next)
				set.add(pair);
		}
		return set;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void clear(){
		buckets = new Entry[SIZE];
	}
	
	@Override
	public V remove(Object key){
		int index = Math.abs(key.hashCode()) % SIZE;
		V oldValue = null;
		Entry<K , V> prePair = null;
		for (Entry<K , V> pair = buckets[index] ; pair != null ; pair = pair.next){
			if (pair.getKey().equals(key)){
				if (prePair == null)
					buckets[index] = pair.next;
				else
					prePair.next = pair.next;
				oldValue = pair.getValue();
				break;
			}
			prePair = pair;
		}
		return oldValue;
	}
	@Override
	public int size(){
		int sz = 0;
		for (Entry<K , V> bucket : buckets)
			for (Entry<K , V> pair = bucket ; pair != null ; pair = pair.next)
				sz++;
		return sz;
	}
	@Override
	public boolean isEmpty() {
		for (Entry<K , V> bucket : buckets)
			if(bucket != null)
				return false;
		return true;
	}
	@Override
	public boolean containsKey(Object key) {
		for (Entry<K , V> bucket : buckets)
			for (Entry<K , V> pair = bucket ; pair != null ; pair = pair.next)
				if (pair.getKey().equals(key))
					return true;
		return false;
	}

}
