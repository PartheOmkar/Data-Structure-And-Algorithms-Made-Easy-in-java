package com.chapter6;
/*
 * Problem-10 :- Give an algorithm for finding the height (or depth) of the binary tree.
Solution:- Recursively calculate height of left and right subtrees of a node and assign height to the
node as max of the heights of two children plus 1. This is similar to PreOrder tree traversal (and
DFS of Graph algorithms).
 */
public class ProblemNo10 extends BinaryTree{

	public void heightOfTree() {
		System.out.println("Height of Tree is = "+heightOfTree(root));
	}
	public int heightOfTree(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		
		return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
	}
	public static void main(String[] args) {
		ProblemNo10 p10 = new ProblemNo10();
		
		p10.nodeInsert(5);
		p10.nodeInsert(7);
		p10.nodeInsert(3);
		p10.nodeInsert(6);
		p10.nodeInsert(1);
		p10.nodeInsert(9);
		p10.nodeInsert(10);
		p10.binaryTreeDisplay();
		
		p10.heightOfTree();
	}
}
