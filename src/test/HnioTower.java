package test;

public class HnioTower {
	public static int index = 1;
	//�� x ���ϵ� n ��Բ��ͨ�� y ���ƶ��� z ���� 
	public static void move(int n , String x , String y , String z) {
		if (n == 1) 
			System.out.println("step" + index++ + " : " + x + "-->" + z);
		else {
			move(n-1 , x , z , y);  //step1:��x�ϵ�n-1��Բ��ͨ��z�ƶ���y��
			System.out.println("step" + index++ + " : " + x + "-->" + z); //����Բ���ƶ���Z��
			move(n-1 , y , x , z);  //step2:��y�ϵ�n-1��Բ��ͨ��x�ƶ���z��
		}
	}
	
	public static void main(String[] args) {
		move(5 , "1" , "2" , "3");
	}
}

