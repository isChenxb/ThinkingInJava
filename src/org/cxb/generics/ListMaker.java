package org.cxb.generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
	List<T> create(T t , int n){
		List<T> result =  new ArrayList<T>();
		for (int i = 0 ; i < n ; i++)
//			result.add(new ListMaker<Integer>());
			result.add(t);
		return result;
	}
	
//	int test(List<Integer> l){
//		return null;
//	}
//	
//	void test(List<String> t){
//		
//	}
	public static void main(String[] args) {
		ListMaker<String> stringMaker = 
				new ListMaker<String>();
		List<String> stringList = stringMaker.create("Hello" , 4);
		System.out.println(stringList);
//		for (String str : stringList)
//			System.out.println(str);
	}
}
