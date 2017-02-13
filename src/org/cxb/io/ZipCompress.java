package org.cxb.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = 
				new FileOutputStream("test.zip");
		CheckedOutputStream cos = 
				new CheckedOutputStream(fos , new Adler32());
		ZipOutputStream zos = 
				new ZipOutputStream(
						new BufferedOutputStream(cos));
//		BufferedOutputStream out = 
//				new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zip test");
		for (String arg : args){
			System.out.println("Writing file " + arg);
			File file = new File(arg);
			BufferedReader in = new BufferedReader(
					new FileReader(file));
			zos.putNextEntry(new ZipEntry(file.getName()));
			int c;
			while((c = in.read()) != -1)
				zos.write(c);
			in.close();
			zos.flush();
		}
		zos.close();
		//Checksum valid only after the file has been closed!
		System.out.println("Checksum: " + cos.getChecksum().getValue());
		System.out.println("Reading file");
		FileInputStream fis = new FileInputStream("test.zip");
		CheckedInputStream cis = new CheckedInputStream(fis , new Adler32());
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(cis));
//	    BufferedInputStream bis = new BufferedInputStream(zis);
	    ZipEntry ze;
	    while((ze = zis.getNextEntry()) != null){
	    	System.out.println("Reading file "  + ze);
	    	int x;
	    	while((x = zis.read()) != -1)
	    		System.out.write(x);
	    }
	    zis.close();
//	    if (args.length == 1)
	    System.out.println("Checksum: " + cis.getChecksum().getValue());
	    //Alternative way to open and read Zip files
	    ZipFile zf = new ZipFile("test.zip");
	    Enumeration e = zf.entries();
	    while(e.hasMoreElements()){
	    	ZipEntry ze2 = (ZipEntry)e.nextElement();
	    	System.out.println("File: " + ze2);
	    }
	}
}
