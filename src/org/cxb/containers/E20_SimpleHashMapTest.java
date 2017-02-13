package org.cxb.containers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class SimpleHashMap2<K, V> extends SimpleHashMap<K, V> {
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		if (buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		else {
			System.out.println("Collision while adding\n" + pair + "\nBucket already contains:");
			Iterator<MapEntry<K, V>> it = buckets[index].iterator();
			while (it.hasNext())
				System.out.println(it.next());
		}
		boolean found = false;
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		int times = 0;
		while (it.hasNext()) {
			times++;
			MapEntry<K, V> mpair = it.next();
			if (mpair.getKey().equals(key)) {
				System.out.println("found the item for times = " + times);
				found = true;
				oldValue = mpair.getValue();
				it.set(pair);
				break;
			}
		}
		if (!found)
			bucket.add(pair);
		return oldValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new LinkedList[SIZE];
	}

	@Override
	public V remove(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while (it.hasNext()){
			MapEntry<K , V> mpair = it.next();
			if (mpair.getKey().equals(key)) {
				V value = mpair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}
}

public class E20_SimpleHashMapTest {
	public static void main(String[] args) {
		SimpleHashMap2<String, String> map = new SimpleHashMap2<String, String>();
		map.put("haha", "001");
		map.put("hahah", "002");
		System.out.println(map);
		map.put("haha", "003");
		System.out.println(map);
		System.out.println(map.remove("hahah"));
		System.out.println(map);
	}
}
