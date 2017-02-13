package org.cxb.regex;

import java.util.regex.Pattern;

public class Test {
	private static Pattern p = Pattern.compile("\\w+\\.");
	private static String str = "goodmorniuii  ngdfjdkf dfdfd";
	public static void main(String[] args) {
		System.out.println(args.length);
		String new_str = p.matcher(str).replaceAll("");
		System.out.println(new_str);
	}
}
