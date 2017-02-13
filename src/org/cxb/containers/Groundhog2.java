package org.cxb.containers;

public class Groundhog2 extends Groundhog{
	public Groundhog2(int n){
		super(n);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("child.equals()");
		return obj instanceof Groundhog && ((Groundhog)obj).number == number;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("child.hashcode()");
		return number;
	}
}
