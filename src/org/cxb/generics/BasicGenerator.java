package org.cxb.generics;

public class BasicGenerator<T> implements Generator<T>{
	private Class<T> type;
	public BasicGenerator(Class<T> type) { this.type = type; }
	
	@Override
	public T next() {
		// TODO Auto-generated method stub
		try {
			return type.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}

}
