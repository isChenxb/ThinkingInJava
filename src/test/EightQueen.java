package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class EightQueen {
	public static int count = 0;
	
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new FileOutputStream("eightQueen.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[][] chess = new int[8][8];
		for (int i = 0 ; i < 8 ; i++)
			for (int j = 0 ; j < 8 ; j++)
				chess[i][j] = 0;
		eightQueen(chess , 0);
		System.out.println(count);
	}
	public static void eightQueen(int[][] chess , int raw){
		int chess2[][] = new int[8][8];
		for (int i = 0 ; i < 8 ; i++)
			for (int j = 0 ; j < 8 ; j++)
				chess2[i][j] = chess[i][j];
		if (raw == 8) {
			count++;
			System.out.println("第" + count + "种:");
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					System.out.print(chess2[i][j] + "  ");
				}
				System.out.print("\r\n");
			}
			System.out.print("\r\n");
		} else {
			for (int low = 0 ; low < 8 ; low++) {
				if (!isDanger(chess2 , raw , low)) {
					for (int j = 0 ; j < 8 ; j++) 
						chess2[raw][j] = 0;
					chess2[raw][low] = 1;
					eightQueen(chess2 , raw + 1);
				}
			}
		}
	}
	
	
	public static boolean isDanger(int[][] chess , int raw , int low) {
		//上方
		for (int i = 0 ; i < raw ; i++) 
			if (chess[i][low] == 1)
				return true;
		//左上
		for (int i = raw - 1 , j = low - 1 ; i >= 0 && j >= 0 ; i-- , j--)
			if (chess[i][j] == 1)
				return true;
		//右上
		for (int i = raw - 1 , j = low + 1 ; i >= 0 && j < 8 ; i-- , j++)
			if (chess[i][j] == 1)
				return true;
		return false;
	}
}
