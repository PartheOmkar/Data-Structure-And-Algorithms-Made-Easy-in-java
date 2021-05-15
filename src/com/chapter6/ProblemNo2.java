package com.chapter6;
/*
 * Problem-2 :- Give an algorithm for finding maximum element in binary tree without recursion.
   Solution: Using level order traversal: just observe the element’s data while deleting.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo2 extends BinaryTree{

	private void maxValue() {
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		int maxVal = 0;
		while(!level.isEmpty()) {
			
			BinaryTreeNode temp = level.remove();
			
			int val = temp.data;
			if(val > maxVal) {
				maxVal = val;
			}
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
		}
		System.out.println("Max Value = "+maxVal);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProblemNo2 p2 = new ProblemNo2();
		p2.nodeInsert(5);
		p2.nodeInsert(4);
		p2.nodeInsert(3);
		p2.nodeInsert(2);
		p2.nodeInsert(1);
		p2.nodeInsert(9);
		p2.binaryTreeDisplay();
		
		p2.maxValue();
	}

}
