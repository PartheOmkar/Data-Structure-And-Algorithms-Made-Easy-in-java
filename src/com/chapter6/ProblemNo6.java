package com.chapter6;
/*
 * Problem-6 Give an algorithm for finding the size of binary tree.
Solution: Calculate the size of left and right subtrees recursively, add 1 (current node) and return
to its parent.
 */
public class ProblemNo6 extends BinaryTree{

	public void findsizeOftree() {
		System.out.println("size of tree is = "+findsizeOftree(root));
	}
	private int findsizeOftree(BinaryTreeNode root) {
	
		int leftsize = root.left==null?0:findsizeOftree(root.left);
		int rightsize = root.right==null?0:findsizeOftree(root.right);
		
		return leftsize+rightsize+1;
	}
	public static void main(String[] args) {
		ProblemNo6 p6 = new ProblemNo6();
		p6.nodeInsert(5);
		p6.nodeInsert(7);
		p6.nodeInsert(3);
		p6.nodeInsert(6);
		p6.nodeInsert(1);
		p6.nodeInsert(9);
		p6.binaryTreeDisplay();
		
		p6.findsizeOftree();
	}
}
