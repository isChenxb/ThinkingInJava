package org.cxb.generics;

public class CountedObject {
	private static int count = 0;
	private int id = count++;
	public int getId(){ return id; }
	public String toString(){
		return "CountedObject£º " + id;
	}
}
