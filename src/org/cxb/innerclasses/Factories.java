package org.cxb.innerclasses;

interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implements1 implements Service {
	private Implements1() {
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Implements1 method1");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Implements1 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implements1();
		}
	};

}

class Implements2 implements Service {
	private Implements2() {
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Implements2 method1");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Implements2 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {
		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implements2();
		}
	};
}

public class Factories {
	public static void serviceConsumer(ServiceFactory factory) {
		Service service = factory.getService();
		service.method1();
		service.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(Implements1.factory);
		serviceConsumer(Implements2.factory);
	}
}
