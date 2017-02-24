package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Count {
	private int count = 0;
	private Random rand = new Random(47);
	public synchronized int increment() {
		int tem = count;
		if (rand.nextBoolean())
			Thread.yield();
		return (count = ++tem);
	}
	public synchronized int value() {
		return count;
	}
}

class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> entrances = 
			new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	public static void cancel() {
		canceled = true;
	}
	public Entrance(int id) {
		this.id = id;
		entrances.add(this);
	}
	@Override
	public void run() {
		while(!canceled) {
			
		}
	}
	
}

public class OrnamentalGarden {

}
