package org.cxb.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddres{
	private String str;
	public StringAddres(String str){
		this.str = str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + str;
	}
}

public class FillingLists {
	public static void main(String[] args) {
		List<StringAddres> list = Collections.nCopies(5, new StringAddres("123"));
		System.out.println(list.getClass().getName());
		System.out.println(list);
		System.out.println(list.size());
	}
}
