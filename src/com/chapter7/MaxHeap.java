package com.chapter7;

import java.util.ArrayList;

public class MaxHeap {

	ArrayList<Integer> maxheap;
	
	public MaxHeap() {
		maxheap = new ArrayList<Integer>();
	}
	
//	parent of heap node
	public int parent(int child) {
		int parent = (child-1)/2;
		if(child<0) {
			return -1;
		}
		return parent;
	}
//	children of node
	// left child
	public int leftChild(int parent) {
		int leftchild = parent*2+1;
		if(leftchild>maxheap.size()-1) {
			return -1;
		}
		return leftchild;
	}
	// right child
	public int rightChild(int parent) {
		int rightchild = parent*2+2;
		if(rightchild>maxheap.size()-1) {
			return -1;
		}
		return rightchild;
	}
//	swap node
	public void swapnode(int child, int parent) {
		int childData = maxheap.get(child);
		int parentData = maxheap.get(parent);
		
		//swaping
		maxheap.remove(child);
		maxheap.add(child, parentData);
		maxheap.remove(parent);
		maxheap.add(parent, childData);
	}
//	insert node in heap
	// Heapifying after insert
	public void heapifying(int child) {
		int parent = parent(child);
		while(maxheap.get(parent) < maxheap.get(child)) {
			swapnode(child, parent);
			child = parent;
			parent = parent(child);
			if(parent==-1) {
				break;
			}
		}
	}
	public void insert(int data) {
		if(maxheap.size()-1<=0) {
			maxheap.add(data);
			return;
		}
		maxheap.add(data);
		heapifying(maxheap.size()-1);
	}
//	delete node
	// heapifying after delete node
	public void precolactDown(int parent) {
		int leftchild = leftChild(parent);
		int rightchild = rightChild(parent);
		int child = 0;
		if(leftchild!=-1&&rightchild!=-1) {
			child = maxheap.get(leftchild)>maxheap.get(rightchild)?leftchild:rightchild;
		}else if(leftchild!=-1 && rightchild==-1) {
			child = leftchild;
		}else if(rightchild!=-1 && leftchild==-1) {
			child = rightchild;
		}else {
			return;
		}
		while(maxheap.get(child)>maxheap.get(parent)) {
			swapnode(child, parent);
			parent = child;
			leftchild = leftChild(parent);
			rightchild = rightChild(parent);
			if(leftchild!=-1&&rightchild!=-1) {
				child = maxheap.get(leftchild)>maxheap.get(rightchild)?leftchild:rightchild;
			}else if(leftchild!=-1 && rightchild==-1) {
				child = leftchild;
			}else if(rightchild!=-1 && leftchild==-1) {
				child = rightchild;
			}else {
				break;
			}
		}
	}
	public int delete() {
		swapnode(maxheap.size()-1, 0);
		int data = maxheap.remove(maxheap.size()-1);
		precolactDown(0);
		return data;
	}
//	destroy heap
	public void destroy() {
		maxheap = null;
	}
//	display heap
	public void display() {
		System.out.println(maxheap);
	}
}
