package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SleepTask extends LiftOff{
	@Override
	public void run() {
		try{
			while(countDown-- > 0){
				System.out.print(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			System.err.println("Interrupted");
		}
	}
}

public class SleepingTask {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0 ; i < 5 ; i++)
			exec.execute(new SleepTask());
		exec.shutdown();
	}
}
