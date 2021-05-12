package com.chapter6;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
//	create datatypes for treenode
	public class BinaryTreeNode{
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		public BinaryTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	BinaryTreeNode root;
	
//	insert element in binary tree
	public void nodeInsert(int data) {
		BinaryTreeNode temp = new BinaryTreeNode(data);
		
		if(root==null) {
			root=temp;
		}else {
			secondNodeInsert(root,temp);
		}
	}
	// insert second element in binary tree
	private void secondNodeInsert(BinaryTreeNode root,BinaryTreeNode temp) {
		
		while(root!=null) {
			if(root.data < temp.data) {
				if(root.right==null) {
					root.right = temp;
					break;
				}else {
					root = root.right;
				}
			}else {
				if(root.left==null) {
					root.left = temp;
					break;
				}else {
					root = root.left;
				}
			}
		}
	}
//	Display binary tree
	public void binaryTreeDisplay() {
		if(root!=null) {
			System.out.println("Display in Inorder");
			binaryTreeDisplayInorder(root);
			System.out.println("\nDisplay in Preorder");
			binaryTreeDisplayPreorder(root);
			System.out.println("\nDisplay in Postorder");
			binaryTreeDisplayPostorder(root);
			System.out.println("\nDiaplay in level");
			binaryTreeDisplaylevel(root);
			System.out.println();
		}else {
			System.out.println("The Tree is Empty");
		}
	}
	private void binaryTreeDisplayInorder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		binaryTreeDisplayInorder(root.left);
		System.out.print(root.data+" ");
		binaryTreeDisplayInorder(root.right);
	}
	private void binaryTreeDisplayPreorder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		binaryTreeDisplayPreorder(root.left);
		binaryTreeDisplayPreorder(root.right);
	}
	private void binaryTreeDisplayPostorder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		binaryTreeDisplayPostorder(root.left);
		binaryTreeDisplayPostorder(root.right);
		System.out.print(root.data+" ");
	}
	private void binaryTreeDisplaylevel(BinaryTreeNode root) {
		Queue<BinaryTreeNode> tq = new LinkedList<BinaryTreeNode>();
		tq.add(root);
		while(!tq.isEmpty()) {
			BinaryTreeNode temp = tq.remove();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				tq.add(temp.left);
			}
			if(temp.right!=null) {
				tq.add(temp.right);
			}
		}
	}
	
}
