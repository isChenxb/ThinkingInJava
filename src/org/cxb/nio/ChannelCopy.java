package org.cxb.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception{
		if (args.length != 2){
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel 
		    in = new FileInputStream(args[0]).getChannel(),
		    out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		while(in.read(buff) != -1){
			buff.flip();  //Prepare for writing
			out.write(buff);
			buff.clear();  //Prepare for reading
		}
		//the best way is using transferTo or transferFrom
//		in.transferTo(0, in.size(), out);
//		out.transferFrom(in, 0, in.size());
		in.close();
		out.close();
	}
}
