package org.cxb.generics;

public class GenericsMethods {
	public static <T> void method2(T t){
		System.out.println(t.toString());
	}
	
	public <T , A , B> void f(T t , A a , B b){
		System.out.print(t.getClass().getSimpleName() +" "
				+ a.getClass().getSimpleName() + " " + b.getClass().getSimpleName() +"\n");
	}
	
	public static void main(String[] args) {
		GenericsMethods g = new GenericsMethods();
		g.f("df", 'a', 33);
		g.f(1.0 , 1.0f , (short)1);
	}
}
