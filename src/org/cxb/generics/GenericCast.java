package org.cxb.generics;

import java.util.ArrayList;
import java.util.List;

class FixedSizeStack<T>{
	private int index = 0;
	private List<Object> storage;
	public FixedSizeStack(int size){
		storage = new ArrayList<Object>();
	}
	public void push(T item){
		storage.add(index++ , item);
	}
	@SuppressWarnings("unchecked")
	public T pop(){
		return (T) storage.get(--index);
	}
}

public class GenericCast {
	public static final int SIZE = 10;
	public static void main(String[] args){
		FixedSizeStack<String> strings =
				new FixedSizeStack<String>(SIZE);
		for (String s : "A B C D E F G H I J k k k k k k k".split(" "))
			strings.push(s);
		for (int i = 0 ; i < SIZE ; i++){
			String s = strings.pop();
			System.out.println(s + " ");
		}
	}
}
