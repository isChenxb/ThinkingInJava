package org.cxb.generics;

public class Customer {
	private static int count = 1;
	
	public static Generator<Customer> generator(){
		return new Generator<Customer>(){

			@Override
			public Customer next() {
				// TODO Auto-generated method stub
				return new Customer();
			}
			
		};
	}
	private int id = count++;
	private Customer(){}
	public String toString(){
		return "Customer " + id;
	}
}

class Teller{
	private static int count = 1;
	
	public static Generator<Teller> generator(){
		return new Generator<Teller>(){

			@Override
			public Teller next() {
				// TODO Auto-generated method stub
				return new Teller();
			}
			
		};
	}
	
	private Teller(){} 
	
	private int id = count++;
	public String toString(){
		return "Teller " + id;
	}
}

