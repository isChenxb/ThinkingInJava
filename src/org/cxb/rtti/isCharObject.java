package org.cxb.rtti;

public class isCharObject {
	public static void main(String[] args) {
		char[] a = {'a','d'};
		Class cc = a.getClass();
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getCanonicalName());
		System.out.println(cc.getSuperclass().getSimpleName());
	}
	
}
