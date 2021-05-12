package com.chapter3;

//Problem-1
//Implement Stack using Linked List

public class ProblemNo1<E>{
	
	private class Node<E>{
		private E data;
		private Node prev;
		
		Node(E data){
			this.data = data;
		}
	}
	
	private Node top;
	
	private void pushNode(E data) {
		
		Node<E> n = new Node<E>(data);
		n.prev = top;
		top = n;
	}
	
	private E popNode() {
		E temp;
		Node tempNode;
		if(!isLinkedStackEmpty()) {
			temp = (E)top.data;
//			tempNode = top.prev;
//			top = null;
//			top = tempNode;
			top = top.prev;
		}else {
			System.out.println("Stack is Empty");
			return null;
		}
		return temp;
	}
	
	private void displayNode() {
		Node temp = top;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}
	
	private boolean isLinkedStackEmpty() {
		
		return (top==null)?true:false;
	}
	
	public static void main(String[] args) {
		
		ProblemNo1<String> p1 = new ProblemNo1<String>();
		
		p1.pushNode("A");
		p1.pushNode("B");
		p1.pushNode("C");
		p1.pushNode("D");
		
		p1.displayNode();
		System.out.println();
		p1.popNode();
		
		p1.popNode();
		p1.popNode();
		p1.displayNode();
		System.out.println();
		p1.pushNode("E");
		p1.displayNode();
		System.out.println();
		p1.popNode();
		p1.displayNode();
		System.out.println(p1.isLinkedStackEmpty());
		
	}

}
