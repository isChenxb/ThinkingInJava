package org.cxb.concurrency;

public abstract class IntGenerator {
	private volatile boolean cancled = false;
	public abstract int next();
	public void cancle() { cancled = true; }
	public boolean isCanceled() { return cancled; }
}
