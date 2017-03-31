package test;

import java.util.Scanner;

class BTree {
	char data;
	BTree lchile, rchile;
}

public class BinaryTree {
	private static Scanner input = new Scanner(System.in);

	public static void buildTree(BTree tree) {
		char c = input.nextLine().charAt(0);
		if (c == '#')
			tree.data = '#';
		else {
			tree.data = c;
			tree.lchile = new BTree();
			buildTree(tree.lchile);
			tree.rchile = new BTree();
			buildTree(tree.rchile);
		}
	}

	public static void showBinaryTree(BTree tree, int dep) {
		if (tree == null)
			return;
		char data = tree.data;
		if (data != '#') {
			System.out.println("µÚ" + dep + "²ã :" + data);
			dep++;
			showBinaryTree(tree.lchile, dep);
			showBinaryTree(tree.rchile, dep);
		}
	}

	public static void main(String[] args) {
		BTree tree = new BTree();
		buildTree(tree);
		showBinaryTree(tree, 1);
	}
}
