package org.cxb.containers;

import java.util.Iterator;

public class E24_SimpleHashSet {
	public static void main(String[] args) {
		SimpleHashSet<String> m = new SimpleHashSet<String>();
		m.addAll(Countries.names(10));
		m.addAll(Countries.names(10));
		System.out.println("m = " + m);
		System.out.println("m.size() = " + m.size());
		Iterator<String> it = m.iterator();
		System.out.println("it.next() = " + it.next());
		it.remove();
		System.out.println("it.next() = " + it.next());
		System.out.println("m = " + m);
		m.remove("ALGERIA");
		System.out.println("m = " + m);
	}
}
