package org.cxb.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blips3 implements Externalizable{
	private int i;
	private String s;
	public Blips3(){
		System.out.println("Blip3 Constructor");
	}
	
	public Blips3(int i , String s){
		this.i = i;
		this.s = s;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Blips3.writeExternal");
		out.writeObject(i);
		out.writeObject(s);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Blips3.readExternal");
		this.i = (int)in.readObject();
		this.s = (String)in.readObject();
	}
	
	public String toString(){
		return s+i;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("Constructing objects");
		Blips3 b3 = new Blips3(1 , "strs");
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("blips3.out"));
		out.writeObject(b3);
		out.close();
		ObjectInputStream in =  new ObjectInputStream(
				new FileInputStream("blips3.out"));
		Blips3 b33 = (Blips3)in.readObject();
		System.out.println(b33);
	}
	
}
