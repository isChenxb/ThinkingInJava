package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;

class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name , int duration){
		super(name);
		this.duration = duration;
		start();
	}
	@Override
	public void run(){
		try{
			TimeUnit.MILLISECONDS.sleep(duration);
		}catch(InterruptedException e){
			System.out.println(getName() + " was interrupted. "
					+ "isInterrupted() = " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakeded");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name , Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}
	@Override
	public void run(){
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + " join completed");
	}
}

class OtherTask extends Thread{
	public OtherTask(String name){
		super(name);
		start();
	}
	@Override
	public void run(){
		System.out.println(getName() + " is running");
	}
}

public class Joining {
	public static void main(String[] args) throws Exception{
		Sleeper sleeper = new Sleeper("sleeper" , 5000);
		Joiner joiner = new Joiner("joiner" , sleeper);
		TimeUnit.MILLISECONDS.sleep(1000);
		OtherTask other = new OtherTask("other");
//		sleeper.interrupt();
	}
}
