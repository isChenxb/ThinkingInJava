package org.cxb.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class DirList {
	public static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		File path = new File(".");
		// if (args.length == 0){
		// list = path.list();
		// }else{
		// list = path.list(new DirFilter(args[0]));
		// }
		foreachDirs(path , args);
		for (String item : list) {
			System.out.println(item);
		}
	}

	public static void foreachDirs(File path , String[] args) {
		if (path.isDirectory()) {
			addList(path , args);
			File[] files = path.listFiles();
			for (File file : files) {
				foreachDirs(file , args);
			}
		}
	}

	public static void addList(File path , String[] args) {
		String[] fileList;
		if (args.length == 0){
			fileList = path.list();
			for (String str : fileList){
				list.add(str);
			}
		}else{
			fileList = path.list(new DirFilter(args[0]));
			for (String str : fileList){
				list.add(str);
			}
		}
	}
}

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
