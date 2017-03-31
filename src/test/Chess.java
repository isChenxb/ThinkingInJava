package test;

import java.util.Scanner;

public class Chess {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dataNums = Integer.parseInt(input.nextLine());
		if (dataNums > 10)
			System.exit(0);
		long[][] datas = new long[dataNums][3];
		for (int i = 0 ; i < dataNums ; i++) {
			datas[i][0] = input.nextLong();
			datas[i][1] = input.nextLong();
			datas[i][2] = input.nextLong();
		}
		for (int i = 0 ; i < datas.length ; i++) {
			if ((datas[i][0] * datas[i][1]) / 2 <= datas[i][2])
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
