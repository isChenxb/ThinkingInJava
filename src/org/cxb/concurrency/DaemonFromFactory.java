package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() has been interrupted");
		}
	}
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0 ; i < 10 ; i++){
			exec.execute(new DaemonFromFactory());
		}
		exec.shutdown();
		TimeUnit.MILLISECONDS.sleep(100);
	}

}
