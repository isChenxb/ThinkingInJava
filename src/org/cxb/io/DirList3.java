package org.cxb.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList3 {
	public static void main(String[] args) {
		File path = new File("./src/org/cxb/rtti");
		String[] list = null;
		if (args.length == 0){
			list = path.list();
		}else{
			list = path.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		}
		for (String item : list){
			System.out.println(item);
		}
	}
}
