package org.cxb.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverCADState {
	public static void main(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("CADState.out"));
		List<Class<? extends Shape>> shapeTypes = 
				(List<Class<? extends Shape>>)in.readObject();
		Line.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>)in.readObject();
		System.out.println(shapes);
		System.out.println(shapeTypes);
	}
}
