package org.cxb.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
	private PipedWriter out = new PipedWriter();
	public PipedWriter getPipedWriter() { return out; }
	@Override
	public void run() {
		try{
			while(true)
				for (char c = 'A' ; c <= 'z' ; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(250);
				}
		} catch(IOException e) {
			System.out.println(e + " Sender write exception");
		} catch(InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		}
	}
}

class Reciver implements Runnable {
	private PipedReader in;
	public Reciver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("Read: " + (char)in.read() + ", ");
			}
		} catch(IOException e) {
			System.out.println(e + "Receiver read exception");
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Reciver reciver = new Reciver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(reciver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
}
