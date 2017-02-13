package org.cxb.containers;

class Link<T>{
	T item;
	Link<T> next;
	
	Link(T item , Link<T> next){
		this.item = item;
		this.next = next;
	}
}

public class SList<T> {
	private Link<T> link = new Link<T>(null , null);
	
	public class Iterator{
		private Link<T> currentLink = link;
		
		public boolean hasNext(){
			if (currentLink.next != null)
				return true;
			else
				return false;
		}
		
		public T next(){
			if (hasNext()){
				currentLink = currentLink.next;
				return currentLink.item;
			}
			return null;
		}
		
		public void add(T item){
			currentLink.next = new Link<T>(item , null);
			currentLink = currentLink.next;
		}
		
		public void remove(){
			if (currentLink.next == null)
				return;
			currentLink = currentLink.next;
			System.out.println("remove : " +  currentLink.item);
			currentLink.item = null;
		}
	}
	
	public Iterator iterator(){
		return new Iterator();
	}
	
	public static void main(String[] args) {
		SList<String> list = new SList<String>();
		SList<String>.Iterator it = list.iterator();
		for (int i = 0 ; i < 10 ; i++)
			it.add(i+"");
		SList<String>.Iterator it2 = list.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
		SList<String>.Iterator it3 = list.iterator();
		while(it3.hasNext()){
			it3.remove();
		}
	}
}
