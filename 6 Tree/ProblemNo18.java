package com.chapter6;
/*
 * Problem-18 Give an algorithm for finding the number of half nodes (nodes with only one
child) in the binary tree without using recursion.
Solution: The set of all nodes with either left or right child (but not both) are called half nodes.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo18 extends BinaryTree{
	
	public void halfNodes() {
		System.out.println("The half Nodes count is = "+halfNodes(root));
	}
	private int halfNodes(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		int count = 0;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			
			if((temp.left!=null&&temp.right==null)||(temp.right!=null&&temp.left==null)) {
				count++;
			}
			if(temp.left!=null)level.add(temp.left);
			if(temp.right!=null)level.add(temp.right);
		}
		return count;
	}
	public static void main(String[] args) {
		ProblemNo18 p18 = new ProblemNo18();
		p18.nodeInsert(5);
		p18.nodeInsert(3);
		p18.nodeInsert(7);
		p18.nodeInsert(2);
		p18.nodeInsert(4);
		p18.nodeInsert(6);
		p18.nodeInsert(9);
		p18.nodeInsert(10);
		p18.nodeInsert(1);
		p18.binaryTreeDisplay();
		
		p18.halfNodes();
	}
}
