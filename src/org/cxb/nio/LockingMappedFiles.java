package org.cxb.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
	static final int LENGTH = 0x8FFFFFF;  //128MB
	static FileChannel fc;
	public static void main(String[] args) throws Exception{
		fc = 
				new RandomAccessFile("test.dat" , "rw").getChannel();
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for (int i = 0 ; i < LENGTH ; i++)
			mbb.put((byte)'x');
		new LockAndModify(mbb , 0 , 0 + LENGTH/3);
		new LockAndModify(mbb , LENGTH/2 , LENGTH/2 + LENGTH/4);
	}
	
	private static class LockAndModify extends Thread{
		private ByteBuffer buff;
		private int start , end;
		public LockAndModify(ByteBuffer mbb , int start , int end){
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();
			start();
		}
		@Override
		public void run() {
			try{
				FileLock fl = fc.lock(start , end - start , false);
				System.out.println("Locked: " + start + " to " + end);
//				System.out.println("position = " + buff.position() 
//				+ " limit = " + buff.limit() + " capacity = " + buff.capacity());
				while(buff.position() < buff.limit() - 1)
//				while(buff.hasRemaining())
					buff.put((byte)(buff.get() + 1));
				fl.release();
				System.out.println("Released: " + start + " to " + end);
			}catch(IOException e){
				throw new RuntimeException(e);
			}
		}
	}
}
