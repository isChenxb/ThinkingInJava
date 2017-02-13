package org.cxb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HowManyCodes {
	private static int lineNum = 0;
	private static int fileNum = 0;
	
	public static void readLines(File file){
		int fileLines = 0;
		try {
			if (file.getName().matches("R\\.java|BuildConfig\\.java"))
				return;
			fileNum++;
			BufferedReader buff = new BufferedReader(
					new FileReader(file));
			String s = "";
			while((s = buff.readLine()) != null){
				fileLines++;
				lineNum++;
			}
			buff.close();
			System.out.println(file.getAbsolutePath() + "  " + fileLines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void readDirs(File[] files , String regex){
		for (File file : files)
			readDirs(file , regex);
	}
	
	public static void readDirs(File file , String regex){
		if (!file.isDirectory()){
			readLines(file);
			return;
		}
		for (File item : file.listFiles()){
			if (item.isDirectory()){
				readDirs(item , regex);
			}else{
				if (item.getName().matches(regex))
					readLines(item);
			}
		}
	}
	
	public static void main(String[] args) {
		if (args.length == 0 ){
			System.out.println(
					"input root dirs as args");
			System.exit(1);
		}
		File[] files = new File[args.length];
		for (int i = 0 ; i < files.length ; i++)
			files[i] = new File(args[i]);
		readDirs(files , ".*\\.java");
		
		System.out.println("fileNum= " + fileNum);
		System.out.println("LineNum= " + lineNum);
	}
}
