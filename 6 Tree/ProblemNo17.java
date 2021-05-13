package com.chapter6;
/*
 * Problem-17 : Give an algorithm for finding the number of full nodes in the binary tree without
	using recursion.
Solution: The set of all nodes with both left and right children are called full nodes.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo17 extends BinaryTree{

	public void findNoofFullNodes() {
		System.out.println("The Full Nodes = "+findNoofFullNodes(root));
	}
	private int findNoofFullNodes(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		int count=0;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			if(temp.left!=null&&temp.right!=null) {
				count++;
			}
			if(temp.left!=null)level.add(temp.left);
			if(temp.right!=null)level.add(temp.right);
		}
		return count;
	}
	public static void main(String[] args) {
		ProblemNo17 p17 = new ProblemNo17();
		p17.nodeInsert(5);
		p17.nodeInsert(3);
		p17.nodeInsert(7);
		p17.nodeInsert(2);
		p17.nodeInsert(4);
		p17.nodeInsert(6);
		p17.nodeInsert(9);
		p17.nodeInsert(1);
		p17.binaryTreeDisplay();
		
		p17.findNoofFullNodes();
	}
}
