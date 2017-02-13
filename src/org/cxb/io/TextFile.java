package org.cxb.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>{
	
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try{
			BufferedReader in = new BufferedReader(
					new FileReader(
							new File(fileName).getAbsoluteFile()));
			try{
				String s;
				while((s = in.readLine()) != null){
					sb.append(s);
					sb.append("\n");
				}
			}finally{
				in.close();
			}
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static void write(String fileName , String text){
		try{
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try{
				out.print(text);
			}finally{
				out.close();
			}
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public TextFile(String fileName , String spliter){
		super(Arrays.asList(read(fileName).split(spliter)));
		if (get(0).equals("")) remove(0);
	}
	
	public TextFile(String fileName){
		this(fileName , "\n");
	}
	
	public void write(String fileName){
		try{
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try{
				for(String item : this){
					out.println(item);
				}
			}finally{
				out.close();
			}
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		String file = read(".\\src\\org\\cxb\\io\\TextFile.java");
//		System.out.println(file);
		write("test.txt" , file);
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		TreeSet<String> words = new TreeSet<String>(new TextFile("test2.txt" , "\\W+"));
		System.out.println(words);
	}
}
