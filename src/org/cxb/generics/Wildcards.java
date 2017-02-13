package org.cxb.generics;

public class Wildcards {
	static void rawArgs(Holder holder , Object arg){
//		holder.set(arg); //Warning
		Object obj = holder.get();
	}
	
	static void unbounderArg(Holder<?> holder , Object arg){
//		holder.set(arg);//ERROR
		Object obj = holder.get();//type information lost
	}
	
	static <T> T exact1(Holder<T> holder){
		T t = holder.get();
		return t;
	}
	
	static <T> T exact2(Holder<T> holder , T arg){
		holder.set(arg);
		T t = holder.get();
		return t;
	}
	
	 static <T> T wildSubtype(Holder<? extends T> holder , T arg){
//		 holder.set(arg) //Error
		 T t = holder.get();
		 return t;
	 }
	 
	 static <T> void wildSupertype(Holder<? super T> holder , T arg){
		 holder.set(arg);
//		 T t = holder.get(); //ERROR
		 Object obj = holder.get();
	 }
	 
	 public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		//Or:
		//raw = new Holder();
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Long lng = 1L;
		
		rawArgs(raw , lng);
		rawArgs(qualified , lng);
		rawArgs(unbounded , lng);
		rawArgs(bounded , lng);
		
		unbounderArg(raw , lng);
		unbounderArg(qualified , lng);
		unbounderArg(unbounded , lng);
		unbounderArg(bounded , lng);
		
//		Object r1 = exact1(raw);  //Warnings
		Long r2 = exact1(qualified);
		Object r3 = exact1(unbounded);  //Must return Object
		Long r4 = exact1(bounded);
		
//		Long r5 = exact2(raw , lng);  //Warning
		Long r6 = exact2(qualified , lng);
//		Long r7 = exact2(unbounded , lng); //Error
//		Long r8 = exact2(bounded , lng); //Error
		
//		Long r9 = wildSubtype(raw , lng);//Warnings
		Long r10 = wildSubtype(qualified , lng);
		Object r11 = wildSubtype(unbounded , lng);
		Long r12 = wildSubtype(bounded , lng);
		
//		wildSupertype(raw , lng);//Warning
		wildSupertype(qualified , lng);
//		wildSupertype(unbounded , lng); //Error
//		wildSupertype(bounded , lng);
	}
}











