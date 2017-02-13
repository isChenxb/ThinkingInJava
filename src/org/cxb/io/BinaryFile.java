package org.cxb.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BinaryFile {
	public static byte[] read(File file) throws IOException{
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(file));
		try{
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			return bytes;
		}finally{
			in.close();
		}
	}
	
	public static byte[] read(String fileName) throws IOException{
		return read(new File(fileName).getAbsoluteFile());
	}
	
	public static void main(String[] args) {
		try {
			byte[] bytes = read("test.txt");
			Map<Byte , Integer> byteMap = new HashMap<Byte , Integer>();
			for (byte bt : bytes){
				if (byteMap.get(bt) != null){
					byteMap.put(bt , byteMap.get(bt)+1);
				}else{
					byteMap.put(bt , 1);
				}
			}
			System.out.println(byteMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
