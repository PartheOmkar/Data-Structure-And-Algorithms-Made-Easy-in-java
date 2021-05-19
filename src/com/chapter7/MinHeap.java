package com.chapter7;

import java.util.ArrayList;

public class MinHeap {
	
	ArrayList<Integer> minheap;
	public MinHeap() {
		minheap = new ArrayList<Integer>();
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
		if(leftchild>minheap.size()-1) {
			return -1;
		}
		return leftchild;
	}
	// right child
	public int rightChild(int parent) {
		int rightchild = parent*2+2;
		if(rightchild>minheap.size()-1) {
			return -1;
		}
		return rightchild;
	}
//	swap node
	public void swapnode(int child, int parent) {
		int childData = minheap.get(child);
		int parentData = minheap.get(parent);
		
		//swaping
		minheap.remove(child);
		minheap.add(child, parentData);
		minheap.remove(parent);
		minheap.add(parent, childData);
	}
//	insert node in heap
	// Heapifying after insert
	public void heapifying(int child) {
		int parent = parent(child);
		while(minheap.get(parent) > minheap.get(child)) {
			swapnode(child, parent);
			child = parent;
			parent = parent(child);
			if(parent==-1) {
				break;
			}
		}
	}
	public void insert(int data) {
		if(minheap.size()-1<=0) {
			minheap.add(data);
			return;
		}
		minheap.add(data);
		heapifying(minheap.size()-1);
	}
//	delete node
	// heapifying after delete node
	public void precolactDown(int parent) {
		int leftchild = leftChild(parent);
		int rightchild = rightChild(parent);
		int child = 0;
		if(leftchild!=-1&&rightchild!=-1) {
			child = minheap.get(leftchild) < minheap.get(rightchild)?leftchild:rightchild;
		}else if(leftchild!=-1 && rightchild==-1) {
			child = leftchild;
		}else if(rightchild!=-1 && leftchild==-1) {
			child = rightchild;
		}else {
			return;
		}
		while(minheap.get(child) < minheap.get(parent)) {
			swapnode(child, parent);
			parent = child;
			leftchild = leftChild(parent);
			rightchild = rightChild(parent);
			if(leftchild!=-1&&rightchild!=-1) {
				child = minheap.get(leftchild) < minheap.get(rightchild)?leftchild:rightchild;
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
		swapnode(minheap.size()-1, 0);
		int data = minheap.remove(minheap.size()-1);
		precolactDown(0);
		return data;
	}
//	destroy heap
	public void destroy() {
		minheap = null;
	}
//	display heap
	public void display() {
		System.out.println(minheap);
	}
}
