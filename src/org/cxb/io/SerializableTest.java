package org.cxb.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerializableTest {
	public static class Book implements Serializable{
		private String name; 
		public Book(String name){
			System.out.println("Book Constructor");
			this.name = name;
		}
		public String toString(){
			return name;
		}
	}
	
	public static class Backpack implements Serializable{
		private Book[] books;
		public Backpack(Book...books){
			System.out.println("Backpack Constructor");
			this.books = new Book[books.length];
			for (int i = 0 ; i < books.length ; i++)
				this.books[i] = books[i];
		}
		public String toString(){
			StringBuilder result = new StringBuilder();
			for (Book book : books)
				result.append(book+" ");
			return result.toString();
		}
	}
	
	public static void main(String[] args) throws Exception{
		Backpack pack = new Backpack(
				new Book("English") , 
				new Book("Chinese") , 
				new Book("ThinkingInJava"));
		System.out.println(pack);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("pack.txt"));
		out.writeObject(pack);
		out.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("pack.txt"));
		Backpack readPack = (Backpack)in.readObject();
		System.out.println(readPack);
	}
}
