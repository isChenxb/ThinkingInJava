package org.cxb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskWithSleep implements Callable<Integer>{
	private static Random rand = new Random(47);
	@Override
	public Integer call() throws Exception {
		Integer time = rand.nextInt(10);
		TimeUnit.SECONDS.sleep(time);
		return time;
	}
}

public class E06_SleepTask {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> list = 
				new ArrayList<Future<Integer>>();
		for (int i = 0 ; i < 3 ; i++)
			list.add(exec.submit(new TaskWithSleep()));
		exec.shutdown();
		int i = 0;
		while(!list.isEmpty()){
			Future<Integer> future = list.get(i % list.size());
			if (future.isDone()){
				try {
					System.out.println(future.get() + " seconds");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.remove(future);
				continue;
			}
			i++;
		}
	}
}
