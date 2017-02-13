package org.cxb.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException{
		try{
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(BufferedInputFile.read(
							".\\src\\org\\cxb\\io\\BufferedInputFile.java").getBytes()));
//			ByteArrayInputStream in = new ByteArrayInputStream(BufferedInputFile.read(
//					".\\src\\org\\cxb\\io\\BufferedInputFile.java").getBytes());
			while(in.available() != 0){
				System.out.print((char)in.readByte());
			}
		}catch(EOFException e){
			System.err.println("End of stream");
		}
	}
}
