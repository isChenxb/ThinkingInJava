package org.cxb.generics;

interface Methodd{
	public void a();
	public void b();
}

class TT implements Methodd{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("it is method a");
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		System.out.println("it is method b");
	}
	
	public void c(){
		System.out.println("it is method c");
	}
	
}

public class Test20 {
	public static <T extends Methodd>  void doo(T t){
		t.a();
		t.b();
	}
	
	public static void main(String[] args) {
		doo(new TT());
	}
}
