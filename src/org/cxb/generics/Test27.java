package org.cxb.generics;

import java.util.ArrayList;
import java.util.List;

public class Test27 {
	public static void main(String[] args) {
		List<? extends Number> list =
				new ArrayList<Integer>();
//		list.add(new Integer(0));
	}
}
