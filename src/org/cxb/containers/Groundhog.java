package org.cxb.containers;

public class Groundhog {
	protected int number;
	public Groundhog(int n){
		number = n;
	}
	public String toString(){
		return "Groundhog #" + number;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Groundhog && number == ((Groundhog)obj).number;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
}
