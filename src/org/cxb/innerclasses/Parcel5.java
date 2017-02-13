package org.cxb.innerclasses;

interface Destination{
	
}

public class Parcel5 {
	
	public Destination destination(){
		class PDestination implements Destination{}
		return new PDestination();
	}
	
	public Destination destination2(){
		class PDestination implements Destination{}
		return new PDestination();
	}
	
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		System.out.println(p.destination().getClass().getName());
		System.out.println(p.destination2().getClass().getName());
	}
}
