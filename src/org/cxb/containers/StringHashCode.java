package org.cxb.containers;

public class StringHashCode {
	public static void main(String[] args) {
//		String[] hellos = "Hello Hello Hello".split(" ");
//		System.out.println(hellos[0].hashCode());
//		System.out.println(hellos[1].hashCode());
		String s1 = "Hello";
		String s2 = new String("Hello");
		System.out.println(s1 == s2);
		System.out.println(s1.hashCode() == s2.hashCode());
	}
}
