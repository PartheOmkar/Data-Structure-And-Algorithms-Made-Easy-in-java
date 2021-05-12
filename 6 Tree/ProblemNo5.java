package com.chapter6;

/*
 * Problem-5 Give an algorithm for inserting an element into binary tree.
Solution: Since the given tree is a binary tree, we can insert the element wherever we want. To
insert an element, we can use the level order traversal and insert the element wherever we find
the node whose left or right child is NULL.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo5 extends BinaryTree{
	
//	i have add insert function already in BinaryTree Class 
//	the following function is an option
	
	public void addnode(int data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		
		// iterative Approach
		insertData(root, newNode);
		// recursive Approach
		insertDataInRecursive(root,data);
	}
	
	private void insertData(BinaryTreeNode root,BinaryTreeNode newNode) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			
			if(temp.left!=null) {
				level.add(temp.left);
			}else {
				temp.left = newNode;
				break;
			}
			
			if(temp.right!=null) {
				level.add(temp.right);
			}else {
				temp.right = newNode;
				break;
			}
		}
	}
	
//	recursive approach on Same Question
	private boolean insertDataInRecursive(BinaryTreeNode root, int data) {

		if(root.left==null) {
			root.left = new BinaryTreeNode(data);
			return true;
		}
		else if(root.right==null) {
			root.right = new BinaryTreeNode(data);
			return true;
		}
		return insertDataInRecursive(root.left, data)||insertDataInRecursive(root.right, data);
	
	}
	public static void main(String[] args) {
		ProblemNo5 p5 = new ProblemNo5();
		
		p5.nodeInsert(5);
		p5.nodeInsert(7);
		p5.nodeInsert(3);
		p5.nodeInsert(6);
		p5.nodeInsert(1);
		p5.nodeInsert(9);
		p5.binaryTreeDisplay();
		
		p5.addnode(12);
		p5.binaryTreeDisplay();
	}
}
