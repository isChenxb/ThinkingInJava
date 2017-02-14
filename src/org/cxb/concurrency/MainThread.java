package org.cxb.concurrency;

public class MainThread {
	public static void main(String[] args) {
		LiftOff lift = new LiftOff();
		lift.run();
	}
}
