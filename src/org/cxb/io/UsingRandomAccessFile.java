package org.cxb.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
	static String file = "rtest.dat";
	public static void display() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file , "r");
		for (int i = 0 ; i < 7 ; i++){
			System.out.println("Value " + i + ": " + raf.readDouble());
		}
		System.out.println(raf.readUTF());
		raf.close();
	}
	
	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file , "rw");
		for (int i = 0 ; i < 7 ; i++){
			raf.writeDouble(i*1.414);
		}
		raf.writeUTF("The end of the file");
		raf.close();
		display();
		raf = new RandomAccessFile(file , "rw");
		raf.seek(5*8);
		raf.writeDouble(3.1415926);
		display();
	}
}
