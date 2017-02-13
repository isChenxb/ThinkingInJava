package org.cxb.containers;

public class Individual implements Comparable<Individual>{
	private static long counter = 0;
	private final long id = counter++;
	private String name;
	public Individual(String s){
		name = s;
	}
	public Individual(){}
	@Override
	public String toString(){
		return getClass().getSimpleName() + 
				(name == null ? "" : " " + name);
	}
	public long id(){
		return id;
	}
	@Override
	public boolean equals(Object obj){
		return obj instanceof Individual && 
				((Individual)obj).id == id;
	}
	@Override
	public int hashCode(){
		int result = 17;
		if (name != null)
			result = 37 * result + name.hashCode();
		result = result * 37 + (int)id;
		return result;
	}
	@Override
	public int compareTo(Individual arg) {
		String first = getClass().getSimpleName();
		String argFirst = getClass().getSimpleName();
		int firstResult = first.compareTo(argFirst);
		if (firstResult != 0)
			return firstResult;
		if (name != null && arg.name != null){
			int secondResult = name.compareTo(arg.name);
			if (secondResult != 0)
				return secondResult;
		}
		return id > arg.id ? 1 : (id == arg.id ? 0 : -1);
	}

}
