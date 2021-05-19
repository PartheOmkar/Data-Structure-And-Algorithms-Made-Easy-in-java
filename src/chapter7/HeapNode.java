package com.chapter7;

import java.util.ArrayList;

public class HeapNode {
	
	ArrayList<Integer> list;
	
	public HeapNode(){
		list = new ArrayList<Integer>();
	}
	
//	find parent of any node
	public int parent(int i) {
		int parent = (i-1)/2;
		if(i<=0) {
			return -1;
		}
		return parent;
	}
	
//	find children Node
	// left children
	public int leftChildren(int i) {
		int left = 2*i+1;
		if(left>= list.size()-1) {
			return -1;
		}
		return left;
	}
	// right children
	public int rightChildren(int i) {
		int right = 2*i+2;
		if(right>= list.size()-1) {
			return -1;
		}
		return right;
	}

//	peek element (get max element)
	public int peekNode() {
		if(list.size()==0) {
			return -1;
		}
		return list.indexOf(0);
	}
	
//	swap element
	public void swaplist(int child, int parent) {
		int childdata = list.get(child);
		int parentdata = list.get(parent);

		list.remove(child);
		list.add(child, parentdata);
		list.remove(parent);
		list.add(parent, childdata);
	}
	
//	insert element in heap
	public void insertMax(int data) {
		if(list.size()<=0) {
			list.add(data);
			return;
		}
		list.add(data);
		int parent = parent(list.size()-1);
		int child = list.size()-1;
		while(list.get(child) > list.get(parent)) {
			swaplist(child, parent);
			child = parent;
			parent = parent(child);
			if(parent==-1) {
				break;
			}
		}
	}
//	heapifiying the element
	// max heap
	public void precolateDown(int parent) {
		int leftchild = leftChildren(parent);
		int rightchild = rightChildren(parent);
		int child = 0;
		if(leftchild != -1 && rightchild!=-1) {
			child = list.get(leftchild) > list.get(rightchild)?leftchild:rightchild;
		}else if(leftchild != -1 && rightchild == -1) {
			child = leftchild;
		}else if(leftchild==-1 && rightchild!=-1){
			child = rightchild;
		}
		else {
			return;
		}
		while(list.get(child)>list.get(parent)) {
			swaplist(child, parent);
			parent = child;
			leftchild = leftChildren(parent);
			rightchild = rightChildren(parent);
			if(leftchild != -1 && rightchild!=-1) {
				child = list.get(leftchild) > list.get(rightchild)?leftchild:rightchild;
			}else if(leftchild != -1 && rightchild == -1) {
				child = leftchild;
			}else if(leftchild==-1 && rightchild!=-1){
				child = rightchild;
			}
			else {
				break;
			}
		}
	}
//	delete a Maxelement
	public int deleteMax() {
		if(list.size()==0) {
			return -1;
		}
		swaplist(0, list.size()-1);
		int data = list.remove(list.size()-1);
		precolateDown(0);
		return data;
	}
//	Destroying Heap
	public void destroyHeap() {
		list.clear();
	}
	
	public static void main(String[] args) {
		
		HeapNode n1 = new HeapNode();
		
		n1.insertMax(1);
		n1.insertMax(2);
		n1.insertMax(3);
		n1.insertMax(4);
		n1.insertMax(19);
		System.out.println(n1.list);
		n1.deleteMax();
		System.out.println(n1.list);
		n1.deleteMax();
		System.out.println(n1.list);
		n1.destroyHeap();
		System.out.println(n1.list);
	}
}
