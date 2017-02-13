package net.mindview.util;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer>{
	private int size;
	public CountingIntegerList(int size){
		this.size = size < 0 ? 0 : size;
	}
	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingIntegerList(20));
	}

}
