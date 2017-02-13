package org.cxb.generics;

public class Test30 {
	public static void main(String[] args) {
		Holder<Integer> intHolder = new Holder<Integer>();
		intHolder.set(1);
		int i = intHolder.get();
	}
}
