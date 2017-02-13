package org.cxb.generics;

import java.util.HashMap;
import java.util.Map;

class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
	Class<T> kind;
	private Map<String , Class<?>> map = new HashMap<String , Class<?>>();
	public ClassTypeCapture(Class<T> kind){
		this.kind = kind;
	}
	
	public void addType(String typeName , Class<?> kind){
		map.put(typeName, kind);
	}
	
	public Object createNew(String typeName){
		Class<?> newClass = map.get(typeName);
		Object obj = null;
		if (newClass != null){
			try{
			obj = newClass.newInstance();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		return obj;
	}
	
	
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 =
				new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		ClassTypeCapture<House> ctt2 = 
				new ClassTypeCapture<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
		ctt2.addType("String", String.class);
		ctt2.addType("House" , House.class);
		ctt2.addType("Building", Building.class);
		String str = (String) ctt2.createNew("String");
		House house = (House) ctt2.createNew("House");
		Building building = (Building) ctt2.createNew("Building");
	}
}
