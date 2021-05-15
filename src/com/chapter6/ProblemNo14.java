package com.chapter6;
/*
 * Problem-14 :- Give an algorithm for finding the deepest node of the binary tree.
Solution: The last node processed from queue in level order is the deepest node in binary tree.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo14 extends BinaryTree{

	public void depestNode() {
		BinaryTreeNode ans = depestNode(root);
		System.out.println("depest node = "+ans.data);
	}
	private BinaryTreeNode depestNode(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		BinaryTreeNode previous=null;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			previous = temp;
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
		}
		return previous;
	}
	public static void main(String[] args) {
		
		ProblemNo14 p14 = new ProblemNo14();
		p14.nodeInsert(5);
		p14.nodeInsert(3);
		p14.nodeInsert(7);
		p14.nodeInsert(2);
		p14.nodeInsert(4);
		p14.nodeInsert(6);
		p14.nodeInsert(9);
		p14.nodeInsert(1);
		p14.binaryTreeDisplay();
		
		p14.depestNode();
	}
}
