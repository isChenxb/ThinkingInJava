package net.mindview.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String> {
	private int size;
	private static String[] chars = "A B C D E F G L I M N O P Q R S T U V W X Y Z".split(" ");

	public CountingMapData(int size) {
		if (size < 0)
			this.size = 0;
		else
			this.size = size;
	}

	private class Entry implements Map.Entry<Integer, String> {
		int index;

		Entry(int index) {
			this.index = index;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).equals(obj);
		}

		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return chars[index % chars.length] + Integer.toString(index / chars.length);
		}

		@Override
		public String setValue(String value) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).hashCode();
		}

	}

	private class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

		private class Iter implements Iterator<Map.Entry<Integer, String>> {
			private Entry entry = new Entry(-1);

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return entry.index < size - 1;
			}

			@Override
			public java.util.Map.Entry<Integer, String> next() {
				// TODO Auto-generated method stub
				entry.index++;
				return entry;
			}

		}

		@Override
		public Iterator<java.util.Map.Entry<Integer, String>> iterator() {
			// TODO Auto-generated method stub
			return new Iter();
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

	}

	private Set<Map.Entry<Integer, String>> entrySet = new EntrySet();

	@Override
	public Set<java.util.Map.Entry<Integer, String>> entrySet() {
		// TODO Auto-generated method stub
		// Set<Map.Entry<Integer, String>> entries =
		// new LinkedHashSet<Map.Entry<Integer , String>>();
		// for (int i = 0 ; i < size ; i++)
		// entries.add(new Entry(i));
		return entrySet;
	}

	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}

}
