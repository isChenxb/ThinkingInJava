package test;

import java.util.Arrays;
import java.util.Scanner;

public class DropArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String str = input.nextLine();
		int[] nums = new int[n];
		String[] strs = str.split(" ");
		for (int i = 0 ; i < nums.length ; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		boolean flag1 = false, flag2 = false;
		int index1 = 0, index2 = 0;
		for (int i = 1 ; i < nums.length ; i++) {
			if (nums[i] < nums[i-1]) {
				flag1 = true;
				index1 = i-1;
				for (int j = i ; j < nums.length ; j++) {
					if (nums[j] < nums[j - 1]) {
						flag2 = true;
						index2 = j;
					} else 
						break;
				}
				break;
			}
		}
		for (int i = index2 + 1 ; i < nums.length ; i++)
			if (nums[i] < nums[i - 1])
				flag2 = false;
		String result = "no";
		if (flag1 && flag2) {
			if (index1 == 0 && index2 == nums.length - 1) {
				result = "yes";
			} else if (index1 == 0) {
				if (nums[0] <= nums[index2 + 1])
					result = "yes";
			}else if (index2 == nums.length - 1) {
				if (nums[index2] >= nums[index1 - 1])
					result = "yes";
			} else {
				if (nums[index1] <= nums[index2 + 1] && nums[index2] >= nums[index1 - 1])
					result = "yes";
			}
		}
		System.out.println(result);
	}
}
