package net.mindview.util;

public class Generated {
	public static <T> T[] array(T[] a , Generator<T> gen){
		 return new CollectionData<T>(gen , a.length).toArray(a);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] array(Class<T> type , Generator<T> gen , int size){
		T[] result = (T[]) java.lang.reflect.Array.newInstance(type, size);
		return new CollectionData<T>(gen , size).toArray(result);
	}
}
