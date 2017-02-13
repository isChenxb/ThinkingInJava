package org.cxb.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit{
	
}

class Apple extends Fruit{
	
}

class Jonathan extends Apple{
	
}

class Orange extends Fruit{
	
}

public class CompilerIntelligence {
	public static void main(String[] args) {
		List<? extends Fruit> flist = 
				Arrays.asList(new Apple());
		List<? extends Fruit> flist2 =
				new ArrayList<Apple>();
		Apple a = (Apple)flist.get(0);
		System.out.println(a);
//		flist2.add
//		flist.add(new Fruit());
	}
}
