package org.cxb.io;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ProcessFiles {
	public interface Strategy{
		void process(File file);
	}
	private Strategy strategy;
	private String ext;
	public ProcessFiles(Strategy strategy , String ext){
		this.strategy = strategy;
		this.ext = ext;
	}
	public void start(String[] args){
		try{
			if (args.length == 0){
				processDirectoryTree(new File("."));
			}else{
				for (String arg : args){
					File fileArg =  new File(arg);
					if (fileArg.isDirectory()){
						processDirectoryTree(fileArg);
					}else{
//						if (!arg.endsWith("."+ext)){
//							arg += "." + ext;
//						}
						if (fileArg.exists() && Pattern.compile(ext).matcher(arg).matches())
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		}catch(IOException e){
			throw new RuntimeException();
		}
	}
	
	public void processDirectoryTree(File root) throws IOException{
		for (File file : Directory.walk(
				root.getAbsolutePath() , ext ))
			strategy.process(file.getCanonicalFile());
	}
	
	public static void main(String[] args) throws ParseException{
		new ProcessFiles(new ProcessFiles.Strategy() {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse("2016-11-12");
			@Override
			public void process(File file) {
				// TODO Auto-generated method stub
				if (file.lastModified() > date.getTime())
					System.out.println(file);
			}
		}, ".*\\.java").start(args);
	}
}
