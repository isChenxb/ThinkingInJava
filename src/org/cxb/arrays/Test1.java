package org.cxb.arrays;

public class Test1 {
	public static void main(String[] args) {
		ArrayOptions.method(new BerylliumSphere[]{
				new BerylliumSphere() , 
				new BerylliumSphere()
		});
		
//		ArrayOptions.method(new BerylliumSphere[2]{
//				new BerylliumSphere() , 
//				new BerylliumSphere()
//		});Error
	}
}
