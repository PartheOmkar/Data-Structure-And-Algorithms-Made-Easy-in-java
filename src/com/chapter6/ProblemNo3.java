package com.chapter6;
/*
 * Problem-3 Give an algorithm for searching an element in binary tree.
Solution: Given a binary tree, return true if a node with data is found in the tree. Recurse down
the tree, choose the left or right branch by comparing data with each nodes data.
 */
public class ProblemNo3 extends BinaryTree{
	
	public void searchNode(int data) {
		if(search(root, data)) {
			System.out.println("Data is Found");
		}else {
			System.out.println("Data is not found");
		}
	}
	private boolean search(BinaryTreeNode root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		return search(root.left, data)||search(root.right, data);
	}
	
	public static void main(String[] args) {
		
		ProblemNo3 p3 = new ProblemNo3();
		p3.nodeInsert(5);
		p3.nodeInsert(4);
		p3.nodeInsert(3);
		p3.nodeInsert(2);
		p3.nodeInsert(1);
		p3.nodeInsert(9);
		p3.binaryTreeDisplay();
		p3.searchNode(5);
		p3.searchNode(12);
	}
}
