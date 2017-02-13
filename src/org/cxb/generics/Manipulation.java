package org.cxb.generics;

import java.util.ArrayList;

class Manipulator<T>{
	private T obj;
	public Manipulator(T x){
//		if (x instanceof Object)
		obj = x;
	}
	public void manipulate(){
		System.out.println(obj.getClass().getSimpleName());
	}
}

public class Manipulation {
	public static void main(String[] args) {
		System.out.println(ArrayList.class);
//		System.out.println(ArrayList<Integer>.class);
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = 
				new Manipulator<HasF>(hf);
		manipulator.manipulate();
	}
}
