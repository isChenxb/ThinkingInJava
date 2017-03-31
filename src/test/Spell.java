package test;

import java.util.Scanner;

public class Spell {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] strs = input.nextLine().toCharArray();
		boolean capsLock = false;
		int tabTimes = 0;
		for (int i = 0 ; i < strs.length ; i++) {
			if (strs[i] >= 'A' && strs[i] <= 'Z' && !capsLock) {
				tabTimes++;
				capsLock = true;
			}
			if (strs[i] >= 'a' && strs[i] <= 'z' && capsLock) {
				tabTimes++;
				capsLock = false;
			}
		}
		System.out.println(tabTimes + strs.length);
	}
}
