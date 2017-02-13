package org.cxb.containers;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Data implements Comparable<Data>{
	private static Random rand = new Random(47);
	Integer i;
	public Data(){
		i = rand.nextInt(100);
	}
	@Override
	public int compareTo(Data arg) {
		// TODO Auto-generated method stub
		return i > arg.i ? 1 : (i == arg.i ? 0 : -1);
	}
	public String toString(){
		return Integer.toString(i);
	}
}

public class E11_PriorityQueueTest {
	public static void main(String[] args) {
		Queue<Data> prior = new PriorityQueue<Data>();
		for (int i = 0 ; i < 10 ; i++)
			prior.offer(new Data());
		while(!prior.isEmpty())
			System.out.println(prior.remove());
	}
}
