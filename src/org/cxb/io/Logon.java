package org.cxb.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable{
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String username , String password){
		this.username = username;
		this.password = password;
	}
	public String toString(){
		return "logon info: \n username: " + username 
				+"\n date: " + date + "\n password: " + password;
	}
	
	public static void main(String[] args) throws Exception{
		Logon logon = new Logon("Tony" , "123456");
		System.out.println(logon);
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("logon.out"));
		out.writeObject(logon);
		out.close();
		TimeUnit.SECONDS.sleep(1);
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("logon.out"));
		logon = (Logon)in.readObject();
		System.out.println(logon);
	}
}
