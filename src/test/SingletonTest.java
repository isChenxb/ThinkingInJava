package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class SingletonTask implements Runnable {
	@Override
	public void run() {
		Singleton.getInstance();
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0 ;  i < 1000 ; i++) {
			exec.execute(new SingletonTask());
		}
		exec.shutdown();
		
	}
}
