package org.cxb.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
	private static <T> Set<T> copy(Set<T> a){
		if (a instanceof EnumSet)
			return ((EnumSet)a).clone();
		else
			return new HashSet(a);
	}
	
	public static <T> Set<T> union(Set<T> a , Set<T> b){
		Set<T> result = copy(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> intersection(Set<T> a , Set<T> b){
		Set<T> result = copy(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> a , Set<T> b){
		Set<T> result = copy(a);
		result.remove(b);
		return result;
	}
	
	public static <T> Set<T> complement(Set<T> a , Set <T> b){
		return difference(union(a , b) , intersection(a , b));
	}
}
