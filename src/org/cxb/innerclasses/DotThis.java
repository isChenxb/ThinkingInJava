package org.cxb.innerclasses;

public class DotThis {
	private class Inner{
		private DotThis getOut(){
			return DotThis.this;
		}
		
		private Inner getInner(){
			return this;
		}
	}
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		System.out.println(dt);
		DotThis.Inner dti= dt.new Inner();
		System.out.println(dti.getOut());
		System.out.println(dti.getInner());
	}
}
