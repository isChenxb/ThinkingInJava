package org.cxb.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReadOnly {
	static Collection<String> data = 
			new ArrayList<String>(Countries.names);
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(data);
		List<String> readOnly = Collections.unmodifiableList(list);
		System.out.println(list);
		System.out.println(readOnly);
//		readOnly.clear();
		list.remove(0);
		System.out.println(readOnly);
	}
}
