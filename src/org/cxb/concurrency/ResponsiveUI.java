package org.cxb.concurrency;

class UnresponsiveUI {
	private volatile double b = 1;
	public UnresponsiveUI() throws Exception {
		while(b > 0)
			b = b + (Math.PI + Math.E) / b;
		System.in.read();
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;
	public ResponsiveUI() {
		setDaemon(true);
		start();
	}
	@Override
	public void run(){
		while(true){
			d = d + (Math.PI + Math.E) / d;
		}
	}
	
	public static void main(String[] args) throws Exception {
//		new UnresponsiveUI();
		new ResponsiveUI();
		System.in.read();
		System.out.println(d);
	}
}
