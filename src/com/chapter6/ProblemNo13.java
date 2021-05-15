package com.chapter6;
/*
 * Give an algorithm for finding the minimum depth of the binary tree.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo13 extends BinaryTree{

	public void minDepth() {
		System.out.println(minDepth(root));
	}
	private int minDepth(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		level.add(null);
		int maxCount = 0;
		BinaryTreeNode previous = null;
		while(!level.isEmpty()) {
			
			BinaryTreeNode temp = level.remove();
			
			if(previous==null && temp==null) {
				break;
			}
			if(temp==null) {
				maxCount++;
				level.add(null);
				previous = temp;
				continue;
			}
			if(temp.left==null&&temp.right==null) {
				return maxCount+1;
			}
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
			previous = temp;
		}
		return maxCount;
	}
	public static void main(String[] args) {
		
		ProblemNo13 p13 = new ProblemNo13();
		
		p13.nodeInsert(5);
		p13.nodeInsert(3);
		p13.nodeInsert(7);
		p13.nodeInsert(1);
//		p13.nodeInsert(4);
		p13.nodeInsert(6);
		p13.nodeInsert(9);
		p13.nodeInsert(10);
		p13.binaryTreeDisplay();
		
		p13.minDepth();
		
	}
}
