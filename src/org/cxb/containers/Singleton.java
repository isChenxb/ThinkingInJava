package org.cxb.containers;

public class Singleton {
	//ÀÁººÊ½
//	private static Singleton single;
//	private Singleton(){}
//	public static Singleton getSingleton(){
//		if (single == null)
//			single = new Singleton();
//		return single;
//	}
	
	//¶öººÊ½
	private static Singleton single = new Singleton();
	private Singleton(){}
	public static Singleton getSingleton(){
		return single;
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s1 == s2);
	}
}
