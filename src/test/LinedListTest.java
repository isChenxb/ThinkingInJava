package test;

import java.util.LinkedList;

public class LinedListTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.push("aaaa");
		list.push("bbbb");
		list.push("cccc");
		
//		System.out.println(list.pop());
//		System.out.println(list.pop());
//		System.out.println(list.pop());
		
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		for (int i = 0 ; i < size ; i++){
			System.out.println(i);
			sb.append(list.pop() + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
