package com.chapter6;
/*
 * Problem-15 :- Give an algorithm for deleting an element (assuming data is given) from binary tree.
    Solution: The deletion of a node in binary tree can be implemented as
	• Starting at root, find the node which we want to delete.
	• Find the deepest node in the tree.
	• Replace the deepest node’s data with node to be deleted.
	• Then delete the deepest node.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo15 extends BinaryTree{

	public void deleteNode(int data) {
		
		BinaryTreeNode dataNode = findNode(root, data);
		System.out.println("Data to be delete = "+findNodewithoutRecursive(root,data).data);
		
		BinaryTreeNode depestNode = findDepestNode(dataNode);
		System.out.println("Depest Node = "+depestNode.data);
		dataNode.data = depestNode.data;
		depestNode = null;
//		System.out.println(depestNode.data);
	}
	
	//this searching method is used for binary search tree
	private BinaryTreeNode findNode(BinaryTreeNode root, int data) {
		if(root==null) {
			return null;
		}
		if(root.data==data) {
			return root;
		}
		return root.data>data?findNode(root.left, data):findNode(root.right, data);
	}
	
	//this searching method is used for simple binary tree
	private BinaryTreeNode findNodewithoutRecursive(BinaryTreeNode root, int data) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		while(!level.isEmpty()) {
			
			BinaryTreeNode temp = level.remove();
			if(temp.data==data) {
				return temp;
			}
			if(temp.left!=null)level.add(temp.left);
			if(temp.right!=null)level.add(temp.right);
		}
		return null;
	}
	
//	find depest node in tree
	private BinaryTreeNode findDepestNode(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTree.BinaryTreeNode>();
		level.add(root);
		BinaryTreeNode previous=null;
		while(!level.isEmpty()) {
			BinaryTreeNode temp = level.remove();
			previous = temp;
			if(temp.left!=null)level.add(temp.left);
			if(temp.right!=null)level.add(temp.right);
		}
		return previous;
	}
	public static void main(String[] args) {
		
		ProblemNo15 p15 = new ProblemNo15();
		p15.nodeInsert(5);
		p15.nodeInsert(3);
		p15.nodeInsert(7);
		p15.nodeInsert(2);
		p15.nodeInsert(4);
		p15.nodeInsert(6);
		p15.nodeInsert(9);
		p15.nodeInsert(1);
		p15.binaryTreeDisplay();
		
		p15.deleteNode(1);
		
		p15.binaryTreeDisplay();
	}
}
