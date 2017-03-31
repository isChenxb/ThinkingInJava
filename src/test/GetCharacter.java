package test;

import java.util.Scanner;

public class GetCharacter {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		char c = (char)input.next().charAt(0);
		if (c != '#') {
			System.out.println(c);
			test();
		}
	}
}
