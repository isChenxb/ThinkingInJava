package org.cxb.generics;

class GenericSetter<T>{
	void set(T arg){
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGS extends GenericSetter<Integer>{
	
}

public class PlainGenericInheritance {
	public void test(DerivedGS dd){
//		dd.set(dd);
//		dd.set
	}
}
