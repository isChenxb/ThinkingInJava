package test;

public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton() {
		System.out.println("instance");
	}
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}
