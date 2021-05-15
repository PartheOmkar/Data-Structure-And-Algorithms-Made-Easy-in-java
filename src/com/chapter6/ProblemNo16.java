package com.chapter6;
/*
 * Problem-16 : Give an algorithm for finding the number of leaves in the binary tree without
using recursion.
Solution: The set of nodes whose both left and right children are NULL are called leaf nodes.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo16 extends BinaryTree{

	public void findLeavesNode() {
		System.out.println("The Leaves Node are = "+findLeavesNode(root));
	}
	private int findLeavesNode(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		int count = 0;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			if(temp.left==null&&temp.right==null) {
				count++;
			}
			if(temp.left!=null)level.add(temp.left);
			if(temp.right!=null)level.add(temp.right);
		}
		return count;
	}
	public static void main(String[] args) {
		ProblemNo16 p16 = new ProblemNo16();
		p16.nodeInsert(5);
		p16.nodeInsert(3);
		p16.nodeInsert(7);
		p16.nodeInsert(2);
		p16.nodeInsert(4);
		p16.nodeInsert(6);
		p16.nodeInsert(9);
		p16.nodeInsert(1);
		p16.binaryTreeDisplay();
		
		p16.findLeavesNode();
	}
}
