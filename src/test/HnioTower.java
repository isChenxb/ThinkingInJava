package test;

public class HnioTower {
	public static int index = 1;
	//将 x 柱上的 n 个圆盘通过 y 柱移动到 z 柱上 
	public static void move(int n , String x , String y , String z) {
		if (n == 1) 
			System.out.println("step" + index++ + " : " + x + "-->" + z);
		else {
			move(n-1 , x , z , y);  //step1:将x上的n-1个圆盘通过z移动到y上
			System.out.println("step" + index++ + " : " + x + "-->" + z); //最大的圆盘移动到Z上
			move(n-1 , y , x , z);  //step2:将y上的n-1个圆盘通过x移动到z上
		}
	}
	
	public static void main(String[] args) {
		move(5 , "1" , "2" , "3");
	}
}

