package org.cxb.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BufferedInputFile {
	public static String read(String fileName) throws IOException{
//		InputStream ins = new FileInputStream(new File(fileName));
//		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null){
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static String readtoLinked(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		LinkedList<String> list = new LinkedList<String>();
		String s;
		int lineCount = 1;
		while((s = in.readLine()) != null){
			list.push(lineCount++ + ": " + s + "\n");
		}
		in.close();
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		for(int i = 0 ; i < size ; i++){
			sb.append(list.pop());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(readtoLinked(".\\src\\org\\cxb\\io\\BufferedInputFile.java"));
	}
}
