package org.cxb.generics;

class Generic1<T> {
	public void setT(T t){}
}

class Generic2<T>{
	public T getT(){ return null; }
}

public class Test28{
	public static <T> void method1(Generic1<? super T> obj , T item){
		obj.setT(item);
	}
	
	public static <T> T method2(Generic2<? extends T> obj){
		return obj.getT();
	}
}
