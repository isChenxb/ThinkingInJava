package org.cxb.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList2 {
	private static long length = 0;
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				if (pattern.matcher(name).matches()){
					length += dir.length();
					return true;
				}
				return false;
			}
		};
	}
	
	public static void main(String[] args) {
		File file = new File("./src/org/cxb/rtti");
		String[] list = null;
		if (args.length == 0){
			list = file.list();
		}else{
			list = file.list(filter(args[0]));
		}
		for(String item : list){
			System.out.println(item);
		}
		System.out.println(length);
	}
}
