package org.cxb.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable{
	public static final int RED = 1 , BLUE = 2 , GREEN = 3;
	private int xPos , yPos , dimension;
	private static Random rand = new Random(47);
	private static int counter = 0;
	public abstract void setColor(int newColor);
	public abstract int getColor();
	public Shape(int xValue , int yValue , int dim){
		xPos = xValue;
		yPos = yValue;
		dimension = dim;
	}
	public String toString(){
		return getClass()+" color[" + getColor() + "] xPos["
				+ xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";  
	}
	
	public static Shape randomFactory(){
		int xVal = rand.nextInt(100);
		int yVal = rand.nextInt(100);
		int dim = rand.nextInt(100);
		switch(counter++ % 3){
		default:
		case 0: return new Circle(xVal , yVal , dim);
		case 1: return new Square(xVal , yVal , dim);
		case 2: return new Line(xVal , yVal , dim);
		}
	}
}

class Circle extends Shape{
	private static int color = RED;

	public Circle(int xValue, int yValue, int dim) {
		super(xValue, yValue, dim);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}

class Square extends Shape{
	private static int color;
	public Square(int xValue, int yValue, int dim) {
		super(xValue, yValue, dim);
		color = RED;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		this.color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}

class Line extends Shape{
	private static int color = RED;
	public static void serializeStaticState(ObjectOutputStream out) throws IOException{
		out.writeObject(color);
	}
	public static void deserializeStaticState(ObjectInputStream in) throws IOException , ClassNotFoundException{
		color = (Integer)in.readObject();
	}
	public Line(int xValue, int yValue, int dim) {
		super(xValue, yValue, dim);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		this.color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}
public class StoreCADState {
	public static void main(String[] args) throws IOException{
		List<Class<? extends Shape>> shapeTypes = 
				new ArrayList<Class<? extends Shape>>();
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0 ; i < 10 ; i++)
			shapes.add(Shape.randomFactory());
		for (int i = 0 ;  i <3 ; i++)
			shapes.get(i).setColor(Shape.GREEN);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("CADState.out"));
		out.writeObject(shapeTypes);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		System.out.println(shapes);
	}
}
