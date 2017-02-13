//package org.cxb.generics;
//
//import java.util.Date;
//
//class Basic{
//	private String value;
//	public void set(String val){
//		value = val;
//	}
//	public String get(){
//		return value;
//	}
//}
//
//class Decorator extends Basic{
//	protected Basic basic;
//	public Decorator(Basic basic){
//		super();
//		this.basic = basic;
//	}
//	public void set(String val){
//		basic.set(val);
//	}
//	public String get(){
//		return basic.get();
//	}
//}
//
//class TimeStamped extends Decorator{
//	private final long timeStamp;
//	public TimeStamped(Basic basic){
//		super(basic);
//		timeStamp = new Date().getTime();
//	}
//	public long getStamp(){
//		return timeStamp;
//	}
//}
//
//class SeriaNumbered extends Decorator{
//	private static long counter = 1;
//	private final long serialNumber = counter++;
//	public SeriaNumbered(Basic basic){
//		super(basic);
//	}
//	public long getSerialNumber(){
//		return serialNumber;
//	}
//}
//
//public class Decoration {
//	public static void main(String[] args) {
//		TimeStamped t = new TimeStamped(new Basic());
//		TimeStamped t2 = new TimeStamped(
//				new SeriaNumbered(
//						new Basic()));
////		t2.getSerialNumber();Error
//		SeriaNumbered s = new SeriaNumbered(new Basic());
//		SeriaNumbered s2 = new SeriaNumbered(
//				new TimeStamped(
//						new Basic()));
//		s2.getSerialNumber();
//	}
//}
