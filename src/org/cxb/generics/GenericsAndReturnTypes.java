package org.cxb.generics;

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter>{
}

public class GenericsAndReturnTypes {
	void test(Getter g){
		
	}
}
