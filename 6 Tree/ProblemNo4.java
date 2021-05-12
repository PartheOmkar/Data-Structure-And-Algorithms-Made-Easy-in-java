package com.chapter6;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem-4
Give an algorithm for searching an element in binary tree without recursion.
Solution: We can use level order traversal for solving this problem. The only change required in
level order traversal is, instead of printing the data, we just need to check whether the root data is
equal to the element we want to search.
 */
public class ProblemNo4 extends BinaryTree{
	
	private void search(int data) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		boolean flag=false;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			if(temp.data==data) {
				flag = true;
				break;
			}
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
		}
		if(flag) {
			System.out.println("Data is Found");
		}else {
			System.out.println("Data is Not Found");
		}
	}
	
	public static void main(String[] args) {
		
		ProblemNo4 p4 = new ProblemNo4();
		
		p4.nodeInsert(5);
		p4.nodeInsert(4);
		p4.nodeInsert(3);
		p4.nodeInsert(2);
		p4.nodeInsert(1);
		p4.nodeInsert(9);
		p4.binaryTreeDisplay();
		
		p4.search(5);
		p4.search(15);
	}
}
