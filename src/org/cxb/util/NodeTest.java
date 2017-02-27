package org.cxb.util;

class SingleLinkedList<T> {
	private Node<T> firstNode;
	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data , Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public SingleLinkedList() {
		firstNode = new Node(null , null);
	}
	
	public void add(T e) {
		Node<T> newNode = new Node(e , null);
		if (firstNode.next != null) {
			newNode.next = firstNode.next;
			firstNode.next = newNode;
		} else 
			firstNode.next = newNode;
	}
	
	public T fastFoundMid() {
		Node<T> fast = firstNode;
		Node<T> mid = firstNode;
		while (fast.next != null) {
			if (fast.next.next != null) {
				fast = fast.next.next;
				mid = mid.next;
			} else {
				fast = fast.next;
			}
		}
		return mid.data;
	}
	
	public T slowFoundMid() {
		int length = 0;
		Node<T> curr = firstNode;
		while (curr.next != null) {
			length++;
			curr = curr.next;
		}
		curr = firstNode;
		for (int i = 0 ; i < length / 2 ; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> curr = firstNode;
		while (curr.next != null) {
			curr = curr.next;
			sb.append(curr.data + " ");
		}
		return sb.toString();
	}
}

public class NodeTest {
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList();
		for (int i = 1 ; i < 1000000 ; i++) {
			list.add(i);
		}
//		System.out.println(list);
		long start1 = System.nanoTime();
		System.out.println(list.fastFoundMid());
		System.out.println(System.nanoTime() - start1);
		long start2 = System.nanoTime();
		System.out.println(list.slowFoundMid());
		System.out.println(System.nanoTime() - start2);
	}
}
