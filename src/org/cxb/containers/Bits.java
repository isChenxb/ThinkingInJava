package org.cxb.containers;

import java.util.BitSet;
import java.util.Random;

public class Bits {
	public static void printBitSet(BitSet bs){
		System.out.println("BitSet : " + bs);
		StringBuilder result = new StringBuilder();
		for (int i = 0 ; i < bs.size() ; i++)
			result.append(bs.get(i) ? "1" : "0");
		System.out.println("bit pattern : " + result.toString());
	}
	
	public static void main(String[] args) {
		Random rand = new Random(47);
		//byte
		byte bt = (byte)rand.nextInt();
		BitSet bs = new BitSet();
		for (int i = 7 ; i >= 0 ; i--)
			if (((1 << i) & bt) != 0)
				bs.set(i);
			else
				bs.clear(i);
		System.out.println("byte value: " + bt);
		printBitSet(bs);
		//short
		short st = (short)rand.nextInt();
		bs.clear();
		for (int i = 15 ; i >= 0 ; i--)
			if (((1 << i) & st) != 0)
				bs.set(i);
			else
				bs.clear(i);
		System.out.println("short value: " + st);
		printBitSet(bs);
		//int
		int it = rand.nextInt();
		bs.clear();
		for (int i = 31 ; i >= 0 ; i--)
			if (((i << i) & it) != 0)
				bs.set(i);
			else
				bs.clear(i);
		System.out.println("int value: " + it);
		printBitSet(bs);
		//test bitsets >= 64 bits
		BitSet b127 = new BitSet();
//		printBitSet(b127);
		b127.set(127);
//		printBitSet(b127);
		System.out.println("set bit 127: " + b127);
		BitSet b255 = new BitSet(65);
		b255.set(255);
		System.out.println("set bit 255: " + b255);
		BitSet b1023 = new BitSet(512);
		b1023.set(1023);
		printBitSet(b1023);
		b1023.set(1024);
		printBitSet(b1023);
		System.out.println("set bit 1023: " + b1023);
	}
}
