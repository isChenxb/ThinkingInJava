package org.cxb.containers;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SimpleHashSet<T> extends AbstractSet<T> {
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	LinkedList<T>[] buckets = new LinkedList[SIZE];
	@Override
	public boolean add(T e) {
		int index = Math.abs(e.hashCode()) % SIZE;
		if (buckets[index] == null)
			buckets[index] = new LinkedList<T>();
		LinkedList<T> bucket = buckets[index];
		ListIterator<T> it = bucket.listIterator();
		while(it.hasNext())
			if (it.next().equals(e))
				return false;
		bucket.add(e);
		return true;
	}
	@Override
	public boolean contains(Object o) {
		int index = Math.abs(o.hashCode()) % SIZE;
		if (buckets[index] == null) return false;
//		LinkedList<T> bucket = buckets[index];
		ListIterator<T>  it = buckets[index].listIterator();
		while(it.hasNext())
			if (it.next().equals(o))
				return true;
		return false;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			private int count;
			private boolean canRemove;
			private int index1 , index2;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return count < size();
			}

			@Override
			public T next() {
				if (hasNext()){
					canRemove = true;
					++count;
					for ( ; ; ){
						while(buckets[index1] == null)
							index1++;
						try{
							return buckets[index1].get(index2++);
						}catch(IndexOutOfBoundsException e){
							index1++;
							index2 = 0;
						}
					}
				}
				throw new NoSuchElementException();
			}
			
			@Override
			public void remove() {
				if (canRemove){
					canRemove = false;
					buckets[index1].remove(--index2);
					if (buckets[index1].isEmpty()){
						buckets[index1++] = null;
						count--;
					}
				}else{
					throw new IllegalStateException();
				}
			}
		};
	}

	@Override
	public int size() {
		int size = 0;
		for (LinkedList<T> bucket : buckets)
			if (bucket != null)
				size += bucket.size();
		return size;
	}

}
