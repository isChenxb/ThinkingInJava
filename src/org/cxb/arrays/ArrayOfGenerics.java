package org.cxb.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la;
		ls[0] = new ArrayList<String>();
//		ls[1] = new ArrayList<Integer>();Error
		
		Object[] objArray = ls;
		objArray[1] = new ArrayList<Integer>();
//		objArray[2] = 1;
		
		List<String> list = new ArrayList<String>();
		list.add("ddd");
		
		
	}
}
