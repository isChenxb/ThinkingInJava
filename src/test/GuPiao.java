package test;

import java.util.Scanner;

public class GuPiao {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while((n = input.nextInt()) != 0)
			out(n);
	}
	
	public static void out(int n) {
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int index = 1;
		int increment = 2;
		int sum = 0;
		while ((index += increment) <= n) {
			sum++;
			increment++;
		}
		System.out.println(n-sum*2);
	}
}
