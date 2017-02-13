package org.cxb.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
	public static <T , S extends Iterable<? extends T>> void apply(S seq , Method f , Object... args){
		try{
			for (T t : seq)
				f.invoke(t , args);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

class Shape{
	public void rotate(){
		System.out.println(this + " rotate");
	}
	public void resize(int newSize){
		System.out.println(this + " resize " + newSize);
	}
}

class Other{
	public void rotate(){
		System.out.println(this + " rotate");
	}
	public void resize(int newSize){
		System.out.println(this + " resize " + newSize);
	}
}

class Square extends Shape{}

class FilledList<T> extends ArrayList<T>{
	public FilledList(Class<? extends T> type , int size){
		try{
			for (int i = 0 ; i < size ; i++)
				add(type.newInstance());
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
}

class ApplyTest{
	public static void main(String[] args) throws Exception{
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0 ; i < 10 ; i++)
			shapes.add(new Shape());
//		List<? extends Shape> newShapes = shapes;
//		Apply.<Shape , List<Shape>>apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes , Shape.class.getMethod("resize" , int.class) , 5);
		
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0 ; i < 10 ; i++)
			squares.add(new Square());
//		Apply.<Shape , List<? extends Shape>>apply(squares, Shape.class.getMethod("rotate"));
//		Apply.apply(squares , Shape.class.getMethod("resize" , int.class) , 5);
//		
		Apply.apply(new FilledList<Shape>(Shape.class , 10) , 
				Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class , 10) , 
				Shape.class.getMethod("resize", int.class) , 5);
		
//		List<Other> others = new ArrayList<Other>();
//		for (int i = 0 ; i < 10 ; i++)
//			others.add(new Other());
//		Apply.apply(others, Other.class.getMethod("rotate"));
	}
}
