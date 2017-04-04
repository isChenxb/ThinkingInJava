package org.cxb.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast {
	public enum  Status { DRY , BUTTERED , JAMMED }
	private Status status = Status.DRY;
	private final int ID;
	public Toast(int idn) { ID = idn; }
	public void butter() { status = Status.BUTTERED; }
	public void jam() { status = Status.JAMMED; }
	public Status getStatus() { return status; }
	public int getId() { return ID; }
	public String toString() {
		return "Toast " + ID + ": " + status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}
class ButterMakeQueue extends LinkedBlockingQueue<Butter> {}
class JamMakeQueue extends LinkedBlockingQueue<Jam> {}

class Butter {}
class PeanutButter extends Butter {}

class Jam {}
class JellyJam extends Jam {}

class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random random = new Random(47);
	public Toaster(ToastQueue toastQueue) {
		this.toastQueue = toastQueue;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(
						100 + random.nextInt(500));
				//Make toast
				Toast toast = new Toast(count++);
				System.out.println(toast);
				//Insert into queue
				toastQueue.put(toast);
			}
		} catch(InterruptedException e) {
			System.out.println("Toaster interrupted!");
		}
		System.out.println("Toaser off");
	}
}

class Butterer implements Runnable {
	private ToastQueue dryQueue , butteredQueue;
	private ButterMakeQueue butterMakeQueue;
	public Butterer(ToastQueue dry , ToastQueue buttered , ButterMakeQueue butterMake) {
		dryQueue = dry;
		butteredQueue = buttered;
		butterMakeQueue = butterMake;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Toast toast = dryQueue.take();
				butterMakeQueue.take();
				toast.butter();
				System.out.println(toast);
				butteredQueue.put(toast);
			}
		} catch(InterruptedException e) {
			System.out.println("Butterer  interruped!");
		}
		System.out.println("Butterer off");
	}
}

class Jammer implements Runnable {
	private ToastQueue butteredQueue , finishedQueue;
	private JamMakeQueue jamMakeQueue;
	public Jammer(ToastQueue buttered , ToastQueue finished , JamMakeQueue jamMake) {
		butteredQueue = buttered;
		finishedQueue = finished;
		jamMakeQueue = jamMake;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Toast toast = butteredQueue.take();
				jamMakeQueue.take();
				toast.jam();
				System.out.println(toast);
				finishedQueue.put(toast);
			}
		} catch(InterruptedException e) {
			System.out.println("Jammer interrupted!");
		}
		System.out.println("Jammer off");
	}
}

class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int count = 0;
	public Eater(ToastQueue finished) {
		finishedQueue = finished;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Toast toast = finishedQueue.take();
				if (toast.getId() != count++ || 
						toast.getStatus() != Toast.Status.JAMMED) {
					System.out.println(">>>> Error: " + toast);
					System.exit(0);
				} else
					System.out.println("Chomp! " + toast);
			}
		} catch(InterruptedException e) {
			System.out.println("Eater interrupted!");
		}
		System.out.println("Eater off");
	}
}


class PeanutButterMaker implements Runnable {
	private ButterMakeQueue butterMakeQueue;
	public PeanutButterMaker(ButterMakeQueue butterMake) {
		butterMakeQueue = butterMake;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(300);
				PeanutButter peanutButter = new PeanutButter();
				System.out.println("make peanutButter");
				butterMakeQueue.put(peanutButter);
			}
		} catch(InterruptedException e) {
			System.out.println("PeanutBuutterMaker interrupted!");
		}
		System.out.println("PeanutButterMaker off");
	}
}

class JellyJamMaker implements Runnable {
	private JamMakeQueue jamMakeQueue;
	public JellyJamMaker(JamMakeQueue jamMake) {
		jamMakeQueue = jamMake;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(300);
				JellyJam jellyJam = new JellyJam();
				System.out.println("JellyJam make");
				jamMakeQueue.put(jellyJam);
			}
		} catch(InterruptedException e) {
			System.out.println("JellyJamMaker interruped!");
		}
		System.out.println("JellyJamMaker  off");
	}
}

public class ToastOMatic {
	public static void main(String[] args) throws Exception {
		ToastQueue dryQueue = new ToastQueue() , 
				butteredQueue = new ToastQueue() ,
				finishedQueue = new ToastQueue();
		ButterMakeQueue peanutQueue = new ButterMakeQueue();
		JamMakeQueue jellyQueue = new JamMakeQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue , butteredQueue , peanutQueue));
		exec.execute(new Jammer(butteredQueue , finishedQueue , jellyQueue));
		exec.execute(new Eater(finishedQueue));
		exec.execute(new PeanutButterMaker(peanutQueue));
		exec.execute(new JellyJamMaker(jellyQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
