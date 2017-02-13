package org.cxb.page184;

public interface InterfaceDemo {
	A a = new A("a");
	A b = new A("B");
}

class A{
	public String a;
	public A(String a){
		System.out.println(a);
		this.a = a;
	}
}
