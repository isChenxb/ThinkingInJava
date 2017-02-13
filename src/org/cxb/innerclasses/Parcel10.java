package org.cxb.innerclasses;

public class Parcel10 {
	public Destination destination(final String dest , final float price){
		return new Destination(){
			private int cost;
			{
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!" + cost);
			}
			private String label = dest;
		};
	}
	
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		p.destination("Tasmaina", 101.395F);
		
	}
}
