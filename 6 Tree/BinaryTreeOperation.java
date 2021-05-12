package com.chapter6;

import java.util.ArrayList;

public class BinaryTreeOperation extends BinaryTree {
	
//	search node from tree
	public void searchInTree(int data) {
		if(root==null) {
			System.out.println("Tree is Empty");
		}else {
			if(searchInTreeb(root,data)) {
				System.out.println("Data is Found");
			}else {
				System.out.println("Data is not found");
			}
		}
	}
	private boolean searchInTreeb(BinaryTreeNode root,int data) {
		// base case
		if(root==null) {
			return false;
		}
		// self work
		if(root.data==data) {
			return true;
		}
		// recursive assumption
		boolean lhs = searchInTreeb(root.left,data);
		boolean rhs = searchInTreeb(root.right,data);
		
		return (lhs || rhs);
	}
	
//	height of tree
	public int heightofTree() {
		int height = 0;
		if(root==null) {
			System.out.println("The Tree is empty");
		}else {
			height = heightofTreeb(root);
		}
		return height;
	}
	private int heightofTreeb(BinaryTreeNode root) {
		// base case
		if(root==null) {
			return 0;
		}
		// recursive assumption
		int lhs = heightofTreeb(root.left);
		int rhs = heightofTreeb(root.right);
		// self work
		return Math.max(lhs, rhs)+1;
	}
	
//	diameater of tree
	public int diameaterofTree() {
		int diameater=0; 
		if(root==null) {
			System.out.println("The Tree is Empty");
		}else {
			diameater = diameaterofTreeb(root);
		}
		return diameater;
	}
	private int diameaterofTreeb(BinaryTreeNode root) {
		// Base Case
		if(root==null) {
			return 0;
		}
		// recursive assumption
		int lhs = diameaterofTreeb(root.left);
		int rhs = diameaterofTreeb(root.right);
		//self work
		int maxDiameater = Math.max(lhs, rhs);
		//recursive assumption
		int height = heightofTreeb(root.left)+heightofTreeb(root.right);
		//self work
		return Math.max(maxDiameater, height);
	}
	
//	check Tree is Balance or not
	public void checkTreeBalance() {
		if(root==null) {
			System.out.println("The Tree is Empty");
		}else {
			if(checkTreeBalanceorNot(root)) {
				System.out.println("Tree is Balance");
			}else {
				System.out.println("Tree is Not Balance");
			}
		}
	}
	private boolean checkTreeBalanceorNot(BinaryTreeNode root) {
		if(root==null) {
			return true;
		}
		boolean lhs = checkTreeBalanceorNot(root.left);
		boolean rhs = checkTreeBalanceorNot(root.right);
		int hls = heightofTreeb(root.left);
		int rls = heightofTreeb(root.right);
		
		System.out.println("Node = "+root.data);
		System.out.println("lhs = "+lhs+" rhs = "+rhs+"left h = "+hls+" right h = "+rls);
		
		return (lhs && rhs && (rls-hls)<1);
	}
	
//	print path of tree
	public void printPath(int data) {
		if(root==null) {
			System.out.println("The Tree is Empty");
		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			getTreePath(root, data, list);
			for(int i : list) {
				System.out.print(i+" ");
			}
		}
	}
	private boolean getTreePath(BinaryTreeNode root,int data,ArrayList<Integer> list){
		if(root==null) {
			return false;
		}
		list.add(root.data);
		if(root.data==data) {
			return true;
		}
		if(getTreePath(root.left, data, list)||getTreePath(root.right, data, list)) {
			return true;
		}
		list.remove(list.size()-1);
		return false;
	}
//	find lowest common ansister between two nodes
	public int lca(int p,int q) {
		int ans = 0;
		System.out.println("\nans Form tras = "+lcaInTraversing(root,p,q));
		
		ArrayList<Integer> ptemp = new ArrayList<Integer>();
		getTreePath(root, p, ptemp);
		ArrayList<Integer> qtemp = new ArrayList<Integer>();
		getTreePath(root,q,qtemp);
		int len = (ptemp.size() > qtemp.size())?qtemp.size():ptemp.size();
		
		for(int i=0;i<len;i++) {
			if(ptemp.get(i)!=qtemp.get(i)) {
				ans = ptemp.get(i-1);
			}
		}
		return ans;
	}
	public int lcaInTraversing(BinaryTreeNode root,int p,int q) {
		if(root==null) {
			return -1;
		}
		if(root.data==p||root.data==q) {
			return 0;
		}
		if(lcaInTraversing(root.left, p, q)!=-1||lcaInTraversing(root.right, p, q)!=1) {
			return 0;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeOperation bt = new BinaryTreeOperation();
		
		bt.nodeInsert(5);
		bt.nodeInsert(3);
		bt.nodeInsert(7);
		bt.nodeInsert(4);
		bt.nodeInsert(2);
		bt.nodeInsert(6);
//		System.out.println("Disply Tree");
//		bt.binaryTreeDisplay();
//		System.out.println("Search in tree 2");
//		bt.searchInTree(2);
//		System.out.println("search in tree 10");
//		bt.searchInTree(10);
//		System.out.println("height of btree is = "+bt.heightofTree());
//		System.out.println("diameater of Tree is = "+bt.diameaterofTree());
//		bt.checkTreeBalance();
//		bt.printPath(2);
//		System.out.println();
//		bt.printPath(7);
		int ans = bt.lca(2, 6);
		System.out.println("\n"+ans);
		
	}

}
