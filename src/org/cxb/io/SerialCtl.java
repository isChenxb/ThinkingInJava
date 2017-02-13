package org.cxb.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class SerialCtl implements Serializable{
	private String a;
	private transient String b;
	public SerialCtl(String a , String b){
		this.a = "Not Transient: " + a;
		this.b = "Transient: " + b;
	}
	public String toString(){
		return a + "\n" + b;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		out.writeObject(b);
	}
	
	private void readObject(ObjectInputStream in) 
			throws IOException , ClassNotFoundException{
		in.defaultReadObject();
		this.b = (String)in.readObject();
	}
	
	public static void main(String[] args) throws Exception{
		SerialCtl ser = new SerialCtl("stra" , "strb");
		System.out.println(ser);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(buf);
		out.writeObject(ser);
		out.close();
		
		TimeUnit.SECONDS.sleep(2);
		
		ObjectInputStream in = new ObjectInputStream(
				new ByteArrayInputStream(buf.toByteArray()));
		ser = (SerialCtl)in.readObject();
		System.out.println(ser);
	}
}
