package org.cxb.generics;

interface FactoryI<T>{
	T create(T arg);
}

class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F f , T t){
		x = f.create(t);
	}
}

class IntegerFactory implements FactoryI<Integer>{

	@Override
	public Integer create(Integer i) {
		return i;
	}
	
}

class Widget{
	public static class Factory implements FactoryI<Widget>{

		@Override
		public Widget create(Widget w) {
			return w;
		}
		
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo2<Integer>(new IntegerFactory() , 12);
		new Foo2<Widget>(new Widget.Factory() , new Widget());
	}
}
