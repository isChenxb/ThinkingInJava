package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RadioCount {
	private int count = 0;
	public synchronized int increment() {
		return ++count;
	}
	public synchronized int getValue() {
		return count;
	}
}

class Sensor implements Runnable {
	private static RadioCount count = new RadioCount();
	private static List<Sensor> sensors = 
			new ArrayList<Sensor>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	public static int getTotalCount() {
		return count.getValue();
	}
	public static int sumSensors() {
		int sum = 0;
		for (Sensor sen : sensors)
			sum += sen.getValue();
		return sum;
	}
	public Sensor(int id) {
		this.id = id;
		sensors.add(this);
	}
	public int getValue() {
		return number;
	}
	
	public static void canceled() {
		canceled = true;
	}
	@Override
	public void run() {
		while(!canceled) {
			number++;
			count.increment();
			System.out.println(this + " Total: " + count.getValue());
		}
	}
	
	@Override
	public String toString() {
		return "#" + id + " number: " + number;
	}
	
}

public class E17_Test {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0 ; i < 5 ; i++)
			exec.execute(new Sensor(i));
		exec.shutdown();
		TimeUnit.SECONDS.sleep(3);
		Sensor.canceled();
		if (exec.awaitTermination(250 , TimeUnit.MILLISECONDS))
			System.out.println("some task not terminated!");
		System.out.println("Total: " + Sensor.getTotalCount());
		System.out.println("sumSensors: " + Sensor.sumSensors());
	}
}
