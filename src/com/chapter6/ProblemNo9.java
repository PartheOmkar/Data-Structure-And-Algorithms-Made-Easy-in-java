package com.chapter6;
/*
 * Problem-9 Give an algorithm for printing the level order data in reverse order. For example,
the output for the below tree(5 3 7 1 6 9) should be: 9 6 1 7 3 5
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProblemNo9 extends BinaryTree {

	public void printDataInReverse() {
		printDataInReverse(root);
	}
	private void printDataInReverse(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		Stack<Integer> data = new Stack<Integer>();
		level.add(root);
		
		while(!level.isEmpty()) {
			
			BinaryTreeNode temp = level.remove();
			data.push(temp.data);
			
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
		}
		while(!data.isEmpty()) {
			System.out.print(data.pop()+" ");
		}
	}
	public static void main(String[] args) {
		
		ProblemNo9 p9 = new ProblemNo9();
		p9.nodeInsert(5);
		p9.nodeInsert(7);
		p9.nodeInsert(3);
		p9.nodeInsert(6);
		p9.nodeInsert(1);
		p9.nodeInsert(9);
		p9.binaryTreeDisplay();
		
		p9.printDataInReverse();
	}
}
