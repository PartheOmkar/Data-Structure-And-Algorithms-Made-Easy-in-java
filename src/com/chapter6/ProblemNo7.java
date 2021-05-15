package com.chapter6;
/*
 * Problem-7 Can we solve Problem-6 without recursion?
Solution: Yes, using level order traversal
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo7 extends BinaryTree{
	
	public void findsizeOfTree() {
		System.out.println(findsizeOfTree(root));
	}
	private int findsizeOfTree(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		int count = 0;
		while(!level.isEmpty()) {
			
			BinaryTreeNode temp = level.remove();
			count++;
			
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		
		ProblemNo7 p7 = new ProblemNo7();
		
		p7.nodeInsert(5);
		p7.nodeInsert(7);
		p7.nodeInsert(3);
		p7.nodeInsert(6);
		p7.nodeInsert(1);
		p7.nodeInsert(9);
		p7.binaryTreeDisplay();
		
		p7.findsizeOfTree();
	}
}
