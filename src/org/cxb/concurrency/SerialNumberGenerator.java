package org.cxb.concurrency;

public class SerialNumberGenerator {
	private static volatile int serialNumber = 0;
	public static synchronized int nextSerialNumber() {
		return serialNumber++;
	}
}
