package org.cxb.rtti;

interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("else " + arg);
	}
	
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Proxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("Proxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
	
}

public class SimpleProxyDemo {
	public static void main(String[] args) {
		Interface realObj = new RealObject();
		realObj.doSomething();
		realObj.somethingElse("hhaa");
		Interface proxy = new SimpleProxy(realObj);
		proxy.doSomething();
		proxy.somethingElse("ddidid");
	}
}
