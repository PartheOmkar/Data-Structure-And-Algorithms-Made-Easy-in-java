package com.chapter6;
/*
 * Problem-20 : Give an algorithm for finding the diameter of the binary tree. The diameter of a
	tree (sometimes called the width) is the number of nodes on the longest path between twoleaves in the tree.
Solution: To find the diameter of a tree, first calculate the diameter of left subtree and right
	subtrees recursively. Among these two values, we need to send maximum value along with
	current level (+1).
 */
public class ProblemNo20 extends BinaryTree{
	
	public void findDiameter() {
		System.out.println(findDiameter(root)+1);
	}
	
	private int findDiameter(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftdiameater = findDiameter(root.left);
		int rightdiameater = findDiameter(root.right);
		
		int diameater = (leftdiameater>rightdiameater)?leftdiameater+1:rightdiameater+1;
		
		int leftHeight = heightofTree(root.left);
		int rightHeight = heightofTree(root.right);
		
		int height = leftHeight>rightHeight?leftHeight:rightHeight;
		
		return diameater>height?diameater:height;
	}
	private int heightofTree(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = heightofTree(root.left);
		int rightHeight = heightofTree(root.right);
		
		return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
	}
	public static void main(String[] args) {
		
		ProblemNo20 p20 = new ProblemNo20();
		p20.nodeInsert(8);
		p20.nodeInsert(7);
		p20.nodeInsert(2);
		p20.nodeInsert(5);
		p20.nodeInsert(6);
		p20.nodeInsert(4);
		p20.nodeInsert(1);
		p20.nodeInsert(0);
		p20.nodeInsert(9);
		p20.nodeInsert(10);
		
		p20.findDiameter();
	}
}
