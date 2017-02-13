package test;

public class OutOfMemory {
	private static int count = 0;
	public int number = 0;
	
	public void method(){
		number++;
		try{
			method();
		}catch(Exception e){
			System.out.println(e + "  " + number);
		}
	}
	
	public static void main(String[] args) {
		while(true){
			new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					System.out.println("ahah");
				}
				
			}).start();
		}
	}
}
