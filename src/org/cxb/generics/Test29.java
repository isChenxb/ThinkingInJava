package org.cxb.generics;

import java.util.ArrayList;
import java.util.List;

public class Test29 {
	static void f1(Holder<List<?>> holder){
		List<?> list = holder.get();
		System.out.println(holder.equals(list));
//		list.add(1);Error
		Integer i = (Integer)list.get(0);
		System.out.println(i);
		System.out.println(list.contains(i));;
		System.out.println(list.indexOf(i));
		holder.set(new ArrayList<Float>());
	}
	
	static void f2(List<Holder<?>> list){
		Holder<?> holder = list.get(0);
		System.out.println(holder.equals(Integer.valueOf(1)));
//		holder.set(new Integer(2));Error
		System.out.println(holder.get());
		list.add(new Holder<Float>(1.0F));
//		List<?> list222;
//		list222 = new ArrayList<Integer>();
		System.out.println(list.get(1).get());
		list.remove(0);
		System.out.println(list.size());
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		f1(new Holder<List<?>>(list1));
		List<Holder<?>> list2 = new ArrayList<Holder<?>>();
		list2.add(new Holder<Integer>(1));
		f2(list2);
	}
}
