package com.chapter6;
/*
 * Problem-19 : Given two binary trees, return true if they are structurally identical.
Solution:
Algorithm:
	• If both trees are NULL then return true.
	• If both trees are not NULL, then recursively check left and right subtree structures.
 */
public class ProblemNo19 extends BinaryTree{

	public boolean checkStructural(BinaryTreeNode root1,BinaryTreeNode root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		if(root1==null||root2==null) {
			return false;
		}
		return(checkStructural(root1.left, root2.right)&&checkStructural(root1.right, root2.left));
	}
	public static void main(String[] args) {
		
		ProblemNo19 p19 = new ProblemNo19();
		p19.nodeInsert(5);
		p19.nodeInsert(4);
		p19.nodeInsert(6);
		BinaryTreeNode root1 = p19.root;
		
		ProblemNo19 p191 = new ProblemNo19();
		p191.nodeInsert(5);
		p191.nodeInsert(4);
		p191.nodeInsert(6);
		BinaryTreeNode root2 = p191.root;
		
		System.out.println(p19.checkStructural(root1,root2));
		
	}
}
