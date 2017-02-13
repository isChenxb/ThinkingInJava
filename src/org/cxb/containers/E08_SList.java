package org.cxb.containers;

import java.util.NoSuchElementException;

interface SListIterator<T>{
	boolean hasNext();
	T next();
	void add(T element);
	void remove();
}

class SList2<T>{
	private Link<T> header = new Link<T>(null , null);
	
	public SList2(){
		header.next = header;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (SListIterator<T> it = iterator() ; it.hasNext() ; ){
			sb.append(it.next());
			if (it.hasNext())
				sb.append(" , ");
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public SListIterator<T> iterator(){
		return new Iterator();
	}
	
	private class Iterator implements SListIterator<T>{
		private Link<T> lastReturned = header;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return lastReturned.next != header;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (lastReturned.next == header)
				throw new NoSuchElementException();
			lastReturned = lastReturned.next;
			return lastReturned.element;
		}

		@Override
		public void add(T element) {
			// TODO Auto-generated method stub
			Link<T> newLink = new Link<T>(element , header);
			if (header.next == header) //Empty
				header.next = newLink;
			else{
				for (Link<T> curr = header ; ; curr = curr.next)
					if (curr.next == header){
						curr.next = newLink;
						break;
					}
			}
			lastReturned = header;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if (lastReturned == header)
				throw new IllegalStateException(); 
			for (Link<T> curr = header ; ; curr = curr.next)
				if (curr.next == lastReturned){
					curr.next = lastReturned.next;
					break;
				}
			lastReturned = header;
		}
		
	}
	
	private class Link<T>{
		T element;
		Link<T> next;
		
		Link(T element , Link<T> next){
			this.element = element;
			this.next = next;
		}
	}
}

public class E08_SList {
	public static void main(String[] args) {
		SList2<String> list = new SList2<String>();
		SListIterator<String> it = list.iterator();
		it.add("haha");
		it.add("hehe");
		it.add("eee");
		it.next();
		it.remove();
		it.add("haha");
		System.out.println(list);
	}
}
