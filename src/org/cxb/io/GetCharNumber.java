package org.cxb.io;

import java.util.HashMap;
import java.util.Map;

public class GetCharNumber {
	public static Map<Character , Integer> getCharMap(String fileName){
		Map<Character , Integer> charMap = new HashMap<Character , Integer>();
		TextFile file = new TextFile(fileName);
		for (String item : file){
			char[] chars = item.toCharArray();
			for (Character c : chars){
				if (charMap.get(c) != null){
					charMap.put(c , charMap.get(c)+1);
				}else{
					charMap.put(c , 1);
				}
			}
		}
		return charMap;
	}
	
	//It's a test
	public static void main(String[] args) {
		System.out.println(getCharMap("test.txt"));
	}
}
