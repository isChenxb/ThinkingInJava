package org.cxb.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bBuff = ByteBuffer.allocate(BSIZE);
		IntBuffer iBuff = bBuff.asIntBuffer();
		iBuff.put(new int[]{454 , 48 , 454 , 4848 , 484 , 111 , 999});
		System.out.println(iBuff.get(3));
		iBuff.put(3, 88888);
		iBuff.flip();
		while(iBuff.hasRemaining()){
			System.out.println(iBuff.get());
		}
	}
}
