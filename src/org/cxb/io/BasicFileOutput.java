package org.cxb.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;

public class BasicFileOutput {
	static String file1 = "E:\\global1.js";
	static String file2 = "E:\\global2.js";
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("E:\\global.js")));
//		LineNumberReader in = new LineNumberReader(
//				new StringReader(
//						BufferedInputFile.read(".\\src\\org\\cxb\\io\\BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(file1)));
		int lineCount = 1;
		String s;
		long timeBefore = System.currentTimeMillis();
		while((s = in.readLine()) != null){
			out.println(lineCount++ + ": " + s);
//			out.println(in.getLineNumber() + ": " + s);
		}
		out.close();
		long timeAfter = System.currentTimeMillis();
		System.out.println("time: " + (timeAfter - timeBefore));
//		System.out.println(BufferedInputFile.read(file1));
		
		writeWithOutBuff();
	}
	
	public static void writeWithOutBuff() throws IOException{
		LineNumberReader in = new LineNumberReader(
				new StringReader(
						BufferedInputFile.read("E:\\global.js")));
		FileWriter out = new FileWriter(new File(file2));
		int lineCount = 1;
		String s;
		long timeBefore = System.currentTimeMillis();
		while ((s = in.readLine()) != null){
			out.write(lineCount++ + ": " + s + "\n");
		}
		out.close();
		long timeAfter = System.currentTimeMillis();
		System.out.println("time: " + (timeAfter - timeBefore));
//		System.out.println(BufferedInputFile.read(file2));
	}
}
