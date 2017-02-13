package org.cxb.containers;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap2<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	@Override
	public V put(K key, V value) {
		if (key == null)
			throw new NullPointerException();
		V oldValue = get(key);
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}

	@Override
	public V get(Object key) {
		if (key == null)
			throw new NullPointerException();
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return entrySet;
	}

	private EntrySet entrySet = new EntrySet();

	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<Map.Entry<K, V>>() {
				private int index = -1;
				boolean canRemove;

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return index < keys.size() - 1;
				}

				@Override
				public java.util.Map.Entry<K, V> next() {
					// TODO Auto-generated method stub
					canRemove = true;
					++index;
					return new MapEntry<K, V>(keys.get(index), values.get(index));
				}

				@Override
				public void remove() {
					if (!canRemove)
						throw new IllegalStateException();
					canRemove = false;
					keys.remove(index);
					values.remove(index--);
				}

			};

		}
		
		@Override
		public boolean contains(Object o) {
			if (o instanceof MapEntry){
				MapEntry<K , V> e = (MapEntry<K , V>)o;
				K key = e.getKey();
				if (keys.contains(key))
					return e.equals(new MapEntry<K , V>(key , get(key)));
			}
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return keys.size();
		}
		
		@Override
		public void clear() {
			keys.clear();
			values.clear();
		}
	}

}
