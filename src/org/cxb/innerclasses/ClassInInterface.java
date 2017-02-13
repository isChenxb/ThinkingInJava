package org.cxb.innerclasses;

public interface ClassInInterface {
	void howdy();
	int i = 1;
	public static void method(){
		System.out.println("hahah" + i);
	}
	public static class Test implements ClassInInterface{

		@Override
		public void howdy() {
			// TODO Auto-generated method stub
			System.out.println("hello");
		}
		
		public static void main(String[] args) {
			new Test().howdy();
			ClassInInterface.method();
		}
		
	}
}
