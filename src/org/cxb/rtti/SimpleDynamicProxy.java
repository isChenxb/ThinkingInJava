package org.cxb.rtti;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object obj){
		proxied = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("proxy = " + proxy.getClass().getName());
//		System.out.println(proxy.toString());
		return method.invoke(proxied, args);
	}
}

public class SimpleDynamicProxy {
	public static void main(String[] args) {
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader() , 
				new Class[]{Interface.class} , 
				new DynamicProxyHandler(new RealObject()));
		System.out.println(proxy + "   " + proxy.getClass().getName());
		proxy.doSomething();
		proxy.somethingElse("ggogogog");
	}
}
