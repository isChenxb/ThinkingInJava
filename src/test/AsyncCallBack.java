package test;

public class AsyncCallBack {
	public static void main(String[] args) {
		Li li = new Li();
		Wang wang = new Wang(li);
		wang.askQuestion("1+1=?");
	}
}
