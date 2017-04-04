package org.cxb.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
	int orderNum;
	public Meal(int num) {
		orderNum = num;
	}
	@Override
	public String toString() {
		return "Meal Order:" + orderNum;
	}
}

class WaiterPerson implements Runnable {
	private Restaurant restaurant;
	public WaiterPerson(Restaurant re) {
		restaurant = re;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized(this) {
					while (restaurant.meal == null) {
//						System.out.println("wait meal");
						wait();
					}
					
					while (!restaurant.tableClean) {
//						System.out.println("wait table");
						wait();
					}
				}
				System.out.println("waiter got the " + restaurant.meal);
				synchronized(restaurant.chref) {
					restaurant.meal = null;
//					System.out.println("notify chref");
					restaurant.chref.notifyAll();
				}
				synchronized(restaurant.busBoy) {
					restaurant.tableClean = false;
//					System.out.println("notify busboy");
					restaurant.busBoy.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("WaiterPerson has been interrupted!");
		}
	}
}

class BusBoy implements Runnable {
	private Restaurant restaurant;
	public BusBoy(Restaurant res) {
		restaurant = res;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while (restaurant.tableClean) {
//						System.out.println("busboy wait");
						wait();
					}
				}
				System.out.println("BusBoy clean the table!");
				synchronized(restaurant.waiter) {
					restaurant.tableClean = true;
					restaurant.waiter.notifyAll();
//					System.out.println("notify waiter  for table");
				}
			}
		} catch (InterruptedException e) {
			System.out.println("BusBoy interrupted");
		}
	}
}

class Chref implements Runnable {
	private Restaurant restaurant;
	private int count = 0;
	public Chref(Restaurant re) {
		restaurant = re;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal != null) {
//						System.out.println("chref wait");
						wait();
					}
				}
				if (++count > 10) {
					System.out.println("meal is useout!");
					restaurant.exec.shutdownNow();
				}
				synchronized(restaurant.waiter) {
					restaurant.meal = new Meal(count);
					restaurant.waiter.notifyAll();
//					System.out.println("notify waiter for meal");
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("chref has been interrupted!");
		}
	}
}

public class Restaurant {
	boolean tableClean = true;
	Meal meal;
	WaiterPerson waiter = new WaiterPerson(this);
	Chref chref = new Chref(this);
	BusBoy busBoy = new BusBoy(this);
	ExecutorService exec = Executors.newCachedThreadPool();
	public Restaurant() {
		exec.execute(waiter);
		exec.execute(chref);
		exec.execute(busBoy);
	}
	public static void main(String[] args) {
		new Restaurant();
	}
}
