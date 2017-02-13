package org.cxb.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable{
	private int n;
	public Data(int i){
		this.n = i;
	}
	public String toString(){
		return Integer.toString(n);
	}
}

public class Worm implements Serializable{
	private static Random rand = new Random(47);
	private Data[] d = {
			new Data(rand.nextInt(10)) , 
			new Data(rand.nextInt(10)) ,
			new Data(rand.nextInt(10))
	};
	private Worm next;
	private char c;
	
	public Worm(int i , char x){
		System.out.println("Worm constructor: " + i);
		c = x;
		if (--i > 0)
			next = new Worm(i , (char)(x+1));
	}
	
	public Worm(){
		System.out.println("Default constructor");
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		sb.append("(");
		for (Data dat : d)
			sb.append(dat);
		sb.append(")");
		if (next != null)
			sb.append(next);
		return sb.toString();
	}
	
	public static void main(String[] args) throws ClassNotFoundException , IOException{
		Worm w = new Worm(6 , 'a');
		System.out.println("w = " + w);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();  //Also flush output
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("worm.out"));
		String s = (String)in.readObject();
		Worm wo = (Worm)in.readObject();
		System.out.print(s);
		System.out.println("wo = " + wo);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();
//		out2.close();
		ObjectInputStream in2 = new ObjectInputStream(
				new ByteArrayInputStream(bout.toByteArray()));
		String s2 = (String)in2.readObject();
		Worm w2 = (Worm)in2.readObject();
		System.out.print(s2);
		System.out.println(w2);
	}
	
}
