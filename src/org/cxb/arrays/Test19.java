package org.cxb.arrays;

import java.util.Arrays;

class DataHolder{
	int data;
	public DataHolder(int data){
		this.data = data;
	}
}

class EquslsDataHolder extends DataHolder{
	public EquslsDataHolder(int data){
		super(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof DataHolder && data == ((DataHolder)obj).data;
	}
}

public class Test19 {
	public static void main(String[] args) {
		DataHolder[] d1 = new DataHolder[5];
		DataHolder[] d2 = new DataHolder[5];
		Arrays.fill(d1 , new DataHolder(1));
		Arrays.fill(d2 , new DataHolder(1));
		System.out.println(Arrays.equals(d1 , d2));
		
		EquslsDataHolder[] d3 = new EquslsDataHolder[5];
		EquslsDataHolder[] d4 = new EquslsDataHolder[5];
		Arrays.fill(d1 , new EquslsDataHolder(1));
		Arrays.fill(d2 , new EquslsDataHolder(1));
		System.out.println(Arrays.equals(d3 , d4));
		
		int[][] a = new int[4][];
		int[] b = new int[3];
//		System.out.println(a);
//		System.out.println(Arrays.deepToString(a));
		method(a);
//		method(b);
//		System.out.println(a.getClass().getSimpleName());
		
		int[][] intArray = new int[3][];
		System.out.println(intArray.getClass().getSuperclass().getName());
		
		
//		obj = new Integer[2];
		
		
//		System.out.println(obj.length);
		
	}
	
	public static void method(Object[] obj){
		
	}
}
