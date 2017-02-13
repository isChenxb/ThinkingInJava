package org.cxb.io;

import java.io.File;

public class MakeDirectories {
	private static void usage(){
		System.err.println(
				"Usage:MakeDirectories path1 ...\n" + 
		        "Creates each path\n" + 
				"Usage:MakeDirectories -d path1...\n" + 
		        "Delete each path\n" + 
				"Usage:MakeDirectories -r path1 path2\n" + 
		        "Renames from path1 to path2");
		System.exit(1);
	}
	
	private static void fileData(File f){
		System.out.println(
				" Absolute path: " + f.getAbsolutePath() + 
				"\n Can read: " + f.canRead() + 
				"\n Can write: " + f.canWrite() + 
				"\n getName: " + f.getName() + 
				"\n getParent: " + f.getParent() + 
				"\n getPath: " + f.getPath() + 
				"\n length: " + f.length() + 
				"\n lastModified: " + f.lastModified());
		if (f.isFile()){
			System.out.println("It's a file");
		}else if (f.isDirectory()){
			System.out.println("It's a directory");
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) usage();
		if (args[0].equals("-r")){
			if (args.length != 3) usage();
			File oldFile = new File(args[1]);
			File newFile = new File(args[2]);
			oldFile.renameTo(newFile);
			fileData(oldFile);
			fileData(newFile);
			return;
		}
		boolean del = false;
		int count = 0;
		if (args[0].equals("-d")){
			del = true;
			count++;
		}
		for ( ; count < args.length ; count++){
			File argFile = new File(args[count]);
			if (argFile.exists()){
				System.out.println(argFile + "  exists");
				if (del){
					System.out.println("deleting..." + argFile);
					argFile.delete();
				}
			}else{
				if (!del){
					argFile.mkdirs();
					System.out.println("created " + argFile);
				}
			}
			fileData(argFile);
		}
	}
}
