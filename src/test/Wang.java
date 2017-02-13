package test;

interface CallBack{
	void solve(String answer);
}

public class Wang implements CallBack{
	private Li li;
	public Wang(Li li){
		this.li = li;
	}
	public void askQuestion(final String question){
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.dealQuestion(Wang.this, question);
			}
		}.start();
		
		play();
	}
	
	public void play(){
		System.out.println("小王出去玩了。。。");
	}
	@Override
	public void solve(String answer) {
		// TODO Auto-generated method stub
		System.out.println("小李告诉小王答案是 " + answer);
	}
	
}
