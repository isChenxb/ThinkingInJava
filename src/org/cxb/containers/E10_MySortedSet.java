package org.cxb.containers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;

class MySortedSet<T> implements SortedSet<T>{
	private final List<T> list;
	public MySortedSet(){
		this.list = new LinkedList<T>();
	}
	private MySortedSet(List<T> list){ this.list = list; }
	public String toString(){ return list.toString(); }
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		checkForNull(o);
		return list.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return list.toArray(a);
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		checkForNull(e);
		int p = Collections.binarySearch((List<Comparable<T>>)list, e);
		if (p < 0){
			p = - (p + 1);
			if (p == list.size())
				list.add(e);
			else
				list.add(p, e);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		checkForNull(o);
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		checkForNull(c);
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		checkForNull(c);
		checkForElements(c);
		boolean res = false;
		for (T item : c)
			res |= add(item);
		return res;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		checkForNull(c);
		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		checkForNull(c);
		return list.removeAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return list.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof MySortedSet && list.equals(((MySortedSet<?>)obj).list);
	}

	@Override
	public Comparator<? super T> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<T> subSet(T fromElement, T toElement) {
		// TODO Auto-generated method stub
		checkForNull(fromElement);
		checkForNull(toElement);
		int fromIndex = list.indexOf(fromElement);
		int toIndex = list.indexOf(toElement);
		checkForValidIndex(fromIndex);
		checkForValidIndex(toIndex);
		try{
			return new MySortedSet<T>(list.subList(fromIndex, toIndex));
		}catch(IndexOutOfBoundsException e){
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public SortedSet<T> headSet(T toElement) {
		// TODO Auto-generated method stub
		checkForNull(toElement);
		int toIndex = list.indexOf(toElement);
		checkForValidIndex(toIndex);
		try{
			return new MySortedSet<T>(list.subList(0, toIndex));
		}catch(IndexOutOfBoundsException e){
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public SortedSet<T> tailSet(T fromElement) {
		// TODO Auto-generated method stub
		checkForNull(fromElement);
		int fromIndex = list.indexOf(fromElement);
		checkForValidIndex(fromIndex);
		try{
			return new MySortedSet<T>(list.subList(fromIndex, list.size()));
		}catch(IndexOutOfBoundsException e){
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		try{
			return list.get(0);
		}catch(IndexOutOfBoundsException e){
			throw new NoSuchElementException();
		}
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		try{
			return list.get(list.size() - 1);
		}catch(IndexOutOfBoundsException e){
			throw new NoSuchElementException();
		}
	}
	/* util methods */ 
	public void checkForNull(Object o){
		if (o == null)
			throw new NullPointerException();
	}
	
	public void checkForElements(Collection<?> c){
		for (Iterator<?> it = c.iterator() ; it.hasNext() ; )
			if (it.next() == null)
				throw new NullPointerException();
	}
	
	public void checkForValidIndex(int index){
		if (index == -1)
			throw new IllegalArgumentException();
	}
	
}

public class E10_MySortedSet{
	public static void main(String[] args) {
		SortedSet<String> sortedSet = 
				new MySortedSet<String>();
		Collections.addAll(sortedSet , 
				"one two three four five six seven eight".split(" "));
		System.out.println(sortedSet);
		String low = sortedSet.first();
		String high = sortedSet.last();
		System.out.println(low);
		System.out.println(high);
		Iterator<String> it = sortedSet.iterator();
		for (int i = 0 ; i <= 6 ; i++){
			if (i == 3) low = it.next();
			if (i == 6) high = it.next();
			else it.next();
		}
		System.out.println(low);
		System.out.println(high);
		System.out.println(sortedSet.subSet(low , high));
		System.out.println(sortedSet.headSet(high));
		System.out.println(sortedSet.tailSet(low));
		System.out.println(sortedSet.contains("three"));
		System.out.println(sortedSet.contains("eleven"));
		System.out.println(sortedSet.addAll(Arrays.asList("three" , "eleven")));
		System.out.println(sortedSet);
		System.out.println(sortedSet.addAll(Arrays.asList("three" , "eleven")));
		System.out.println(sortedSet);
		try{
			sortedSet.addAll(Arrays.asList("zero" , null));
		}catch(NullPointerException e){
			System.out.println("Null elements not supported!");
		}
		System.out.println(sortedSet);
	}
}
