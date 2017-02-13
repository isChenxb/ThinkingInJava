package org.cxb.generics;

import java.util.ArrayList;
import java.util.List;

abstract class Ha<T extends Ha<T>>{
	abstract T method1(T item);
	
	public T method2(T item){
		return method1(item);
	}
}

class He extends Ha<He>{

	@Override
	He method1(He item) {
		// TODO Auto-generated method stub
		return item;
	}
	
}

public class Test34 {
	public static void main(String[] args) {
		He he1 = new He();
		He he2 = new He();
		He he3 = he1.method2(he2);
		List list = new ArrayList<Integer>();
	}
}
