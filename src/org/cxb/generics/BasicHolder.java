package org.cxb.generics;

public class BasicHolder<T> {
	T element;
	void set(T item){
		element = item;
	}
	T get(){
		return element;
	}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}
