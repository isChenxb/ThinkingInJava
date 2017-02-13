package org.cxb.generics;

import java.lang.reflect.InvocationTargetException;

class A{
	public A(String i){
		System.out.println(i);
	}
}



public class Test22<T> {
	T t;
	public Test22(Class<T> kind) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		t = kind.getConstructor(String.class).newInstance("hkj");
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Test22<A> test = 
				new Test22<A>(A.class);
		
	}
}
