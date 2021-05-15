package com.chapter6;
/*
 * Problem-1 :- Give an algorithm for finding maximum element in binary tree.
   Solution: One simple way of solving this problem is: find the maximum element in left subtree,
	find the maximum element in right sub tree, compare them with root data and select the one which
	is giving the maximum value. This approach can be easily implemented with recursion.
 */
public class ProblemNo1 extends BinaryTree {
	
	private void maxValue() {
		
		System.out.println(maxValue(root));
	}
	private int maxValue(BinaryTreeNode root) {
		int maxVal = 0;
		
		if(root!=null) {
			int leftmax = maxValue(root.left);
			int rightmax = maxValue(root.right);
			
			if(rightmax > leftmax) {
				maxVal = rightmax;
			}else {
				maxVal = leftmax;
			}
			
			if(root.data > maxVal) {
				maxVal = root.data;
			}
		}
		return maxVal;
	}
	
	public static void main(String[] args) {
		
		ProblemNo1 p1 = new ProblemNo1();
		
		p1.nodeInsert(5);
		p1.nodeInsert(4);
		p1.nodeInsert(3);
		p1.nodeInsert(2);
		p1.nodeInsert(1);
		p1.nodeInsert(9);
		p1.binaryTreeDisplay();
		
		p1.maxValue();
	}
}
