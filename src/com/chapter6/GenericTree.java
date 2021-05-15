package com.chapter6;

import java.util.ArrayList;

public class GenericTree {
	
	public class GenericTreeNode{
		int data;
		ArrayList<GenericTreeNode> childerents;
		public GenericTreeNode(int data) {
			this.data = data;
			childerents = new ArrayList<GenericTreeNode>();;
		}
	}
	GenericTreeNode root=null;
	
	public void insertdata(int data,int parent) {
		GenericTreeNode newNode = new GenericTreeNode(data);
		if(root==null) {
			root = newNode;
		}else {
			insertdata(root,newNode,parent);
		}
	}
	private void insertdata(GenericTreeNode root, GenericTreeNode newNode,int parent) {
		if(root.data==parent) {
			root.childerents.add(newNode);
			return;
		}
		for(GenericTreeNode i : root.childerents) {
			insertdata(i, newNode, parent);
		}
	}
	
	public void diaplayTree() {
		displayTree(root);
	}
	private void displayTree(GenericTreeNode root) {
		
		for(GenericTreeNode i:root.childerents) {
			System.out.println(i.data);
			if(i.childerents!=null) {
				displayTree(i);
			}
		}
	}
	public static void main(String[] args) {
		
		GenericTree t = new GenericTree();
		
		t.insertdata(0,0);
		t.insertdata(5, 0);
		t.insertdata(1, 0);
		t.insertdata(6, 0);
		t.insertdata(2, 1);
		t.insertdata(11, 2);
		t.insertdata(7, 2);
		t.insertdata(8, 7);
		t.insertdata(4, 6);
		
		t.diaplayTree();
		
	}
}
