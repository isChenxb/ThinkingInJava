package org.cxb.concurrency;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("Started ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("it is finally");
		}
	}
	
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
