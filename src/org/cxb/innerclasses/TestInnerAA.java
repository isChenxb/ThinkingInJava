package org.cxb.innerclasses;

class DotInner {
	private int a = 0;

	class Inner {
		private int a = 0;

		private Inner() {};
	}
	
	public Inner getInner(){
		return new Inner();
	}

}

public class TestInnerAA {
	public static void main(String[] args) {
		DotInner dt = new DotInner();
		DotInner.Inner inner = dt.getInner();
	}
}
