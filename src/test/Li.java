package test;

public class Li {
	public void dealQuestion(CallBack callBack , String question){
		System.out.println("С��������: " + question);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����2
		callBack.solve("2");
	}
}
