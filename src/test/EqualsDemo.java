package test;

class Equals{
	private int i;
	public Equals(int i){ this.i = i; }
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("equals() run");
		return obj instanceof Equals && ((Equals)obj).i == i;
//		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return i;
	}
}

public class EqualsDemo {
	public static void main(String[] args) {
		Equals e1 = new Equals(1);
		Equals e2 = new Equals(1);
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
	}
}
