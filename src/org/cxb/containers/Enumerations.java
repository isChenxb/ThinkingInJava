package org.cxb.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {
	public static void main(String[] args) {
		Vector<String> v = 
				new Vector<String>(Countries.names);
		Enumeration<String> e = v.elements();
//		e = Collections.enumeration(new ArrayList<String>(Countries.names));
		while(e.hasMoreElements())
			System.out.println(e.nextElement());
	}
}
