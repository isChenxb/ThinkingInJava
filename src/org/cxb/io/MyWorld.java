package org.cxb.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable{
	
}

class  Animal implements Serializable{
	private String name;
	private House house;
	public Animal(String name , House house){
		this.name = name;
		this.house = house;
	}
	public String toString(){
		return name + "[" + super.toString() + "]£¬ " + house + "\n"; 
	}
}
public class MyWorld{
	public static void main(String[] args) throws IOException , ClassNotFoundException{
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog" , house));
		animals.add(new Animal("Ralph the hamster" , house));
		animals.add(new Animal("Molly the cat" , house));
		System.out.println("animals: " + animals);
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream out1 = new ObjectOutputStream(buf1);
		out1.writeObject(animals);
		out1.writeObject(animals);
		out1.close();
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(buf2);
		out2.writeObject(animals);
		out2.close();
		
		ObjectInputStream in1 = new ObjectInputStream(
				new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(
				new ByteArrayInputStream(buf2.toByteArray()));
		List
		    animals1 = (List)in1.readObject() ;
		animals1.add(new Animal("hahhah" , new House()));
		List
		    animals2 = (List)in1.readObject() , 
		    animals3 = (List)in2.readObject();
		System.out.println(animals1);
		System.out.println(animals2);
		System.out.println(animals3);
	}
}
