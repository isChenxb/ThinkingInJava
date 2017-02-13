package org.cxb.nio;

import java.nio.ByteBuffer;

public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer  buff = ByteBuffer.allocate(BSIZE);
		//Allocation automatically zeroes the ByteBuffer:
		int i = 0;
		while(i++ < buff.limit())
			if (buff.get() != 0)
				System.out.print("nonzero");
		System.out.println("i = " + i);
		buff.rewind();
		//Store and read a char array
		buff.asCharBuffer().put("Howdy!");
		char c;
		while((c = buff.getChar()) != 0)
			System.out.print(c + " ");
		System.out.println("");
		buff.rewind();
		//Store and read a short
		buff.asShortBuffer().put((short)471142);
		System.out.println(buff.getShort());
		buff.rewind();
		//Store and read a int
		buff.asIntBuffer().put(99471142);
		System.out.println(buff.getInt());
		buff.rewind();
		//Store and read a long
		buff.asLongBuffer().put((long)99471142);
		System.out.println(buff.getLong());
		buff.rewind();
		//Store and read a float
		buff.asFloatBuffer().put(9944545);
		System.out.println(buff.getFloat());
		buff.rewind();
		//Store and read a double
		buff.asDoubleBuffer().put(454646545);
		System.out.println(buff.getDouble());
		buff.rewind();
	}
}
