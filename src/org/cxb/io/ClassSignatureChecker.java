package org.cxb.io;

import java.io.File;
import java.io.IOException;

public class ClassSignatureChecker {
	final static byte[] signature = {
			(byte)202 , (byte)254 , (byte)186 , (byte)190
	};
	public static void main(String[] args) throws IOException{
		Directory.TreeInfo info = Directory.walk("." , ".*\\.class");
		for (File file : info){
			byte[] bytes = BinaryFile.read(file);
			for (int i = 0 ; i < signature.length ; i++){
				if (bytes[i] != signature[i]){
					System.err.println(file + "is corrupt!");
					break;
				}else{
					System.out.println(file + "is OK");
				}
			}
		}
	}
}
