package test;

import java.util.Scanner;

public class DeyuerTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		char[] result = new char[chars2.length];
		for (int i = 0 ; i < chars1.length ; i++) {
			if ((chars1[i] >= '0' && chars1[i] <= '9') || 
					(chars1[i] >= 'A' && chars1[i] <= 'Z') ||
					(chars1[i] >= 'a' && chars1[i] <= 'z'))
				result[i] = '1';
			else 
				result[i] = '0';
		}
		float sameCount = 0.f;
		for (int i = 0 ; i < result.length ; i++) {
			if (result[i] == chars2[i])
				sameCount++;
		}
		System.out.println(String.format("%.2f", sameCount / result.length * 100) + "%");
	}
}
