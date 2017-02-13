package org.cxb.containers;

import java.util.LinkedList;
import java.util.Stack;


enum Month {
	JANUARY , FEBRUARY , MARCH , APRIL , MAY , 
	JUNE , JULY , AUGUST , SEPTEMBER , OCTOBER , NOVEMER
}

public class Stacks {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (Month month : Month.values())
			stack.push(month.toString());
		stack.addElement("the last line");
		System.out.println("stack = " + stack);
		System.out.println("element 5 = " + stack.elementAt(5));
		System.out.println("poping elements : ");
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
		
		LinkedList<String> lstack = 
				new LinkedList<String>();
		for (Month month : Month.values())
			lstack.push(month.toString());
		System.out.println("lstack =  " + lstack);
		while(!lstack.isEmpty())
			System.out.print(lstack.pop() + " ");
		System.out.println();
	}
}
