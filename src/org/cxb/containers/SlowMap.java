package org.cxb.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> implements Map<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	public V put(K key, V value) {
		V oldValue = get(key);
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}

	public V get(Object key) {
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while (ki.hasNext())
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
		return set;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return keys.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return values.contains(value);
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// SlowMap<String , String> m = new SlowMap<String , String>();
		Map<String, String> m = new HashMap<String, String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("EGYPT"));
		System.out.println(m.entrySet());
		Iterator<Map.Entry<String, String>> it = m.entrySet().iterator();
		it.next();
		it.remove();
		System.out.println(m.entrySet());
	}
}
