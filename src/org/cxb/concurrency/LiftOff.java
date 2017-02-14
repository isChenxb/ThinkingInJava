package org.cxb.concurrency;

public class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#" + id + "("
				+ (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		while(countDown-- > 0){
			System.out.print(status());
			Thread.yield();
		}
	}
	
}
