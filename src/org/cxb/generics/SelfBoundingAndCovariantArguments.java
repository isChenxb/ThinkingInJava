package org.cxb.generics;

class SelfBoundSetter<T extends SelfBoundSetter<T>>{
	void set(T arg){
		System.out.println("hahaha");
	}
}

class Setter extends SelfBoundSetter<Setter>{
	
}

public class SelfBoundingAndCovariantArguments {
	static void test(Setter s1 , Setter s2 , SelfBoundSetter sbs){
		s1.set(s2);
//		s1.set(sbs);
		
	}
	
	public static void main(String[] args) {
		test(new Setter() , new Setter() , new SelfBoundSetter());
	}
}
