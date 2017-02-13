package org.cxb.rtti;

import java.util.Arrays;
import java.util.List;

abstract class Shape{
	void draw(){
		System.out.println(this+".draw()");
	}
	
	public abstract String toString();
}

class Circle extends Shape{
	String str;
	public String toString(){
		return "Circle";
	}
}

class Square extends Shape{
	public String toString(){
		return "Square";
	}
}

class Triangle extends Shape{
	public String toString(){
		return "Triangle";
	}
}

class Rhomboid extends Shape{
	public String toString(){
		return "Rhomboid";
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Circle circle = new Circle();
		extendsTree(circle);
		Class classd = Integer.TYPE;
//		List<Shape> list = Arrays.asList(new Circle(),new Square(),new Triangle());
//		Class cricleClass = null;
//		try {
//			cricleClass = Class.forName("org.cxb.rtti.Circle");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("class not found!");
//		}
//		for (Shape shape : list){
//			if (shape.getClass().isInstance(new Circle())){
//				continue;
//			}
//			shape.draw();
//		}
		
//		Shape shape = new Rhomboid();
//		shape.draw();
//		if (shape instanceof Circle){
//			Circle rhomboid = (Circle)shape;
//			rhomboid.draw();
//		}
	}
	
	public static void extendsTree(Object obj){
		Class objClass = obj.getClass();
		while(true){
			System.out.println(objClass.getSimpleName()+"   "+objClass.getDeclaredFields().length);
			objClass = objClass.getSuperclass();
			if (objClass==null){
				break;
			}
		}
	}
}
