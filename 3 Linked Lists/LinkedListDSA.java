package com.chapter3;

public class LinkedListDSA<E> {
	
	private class Node<E>{
		E data;
		Node next;
		
		public Node(E data) {
//			super();
			this.data = data;
		}
	}
	
	private Node head;
	
//	insert data 
//	insert data at first element
	void insertAtStart(E Data) {
		Node<E> n = new Node<E>(Data);
		n.next = head;
		head = n;
	}
	void insertAtMid(E Data, int pos) {
		
		Node<E> n = new Node<E>(Data);
		Node temp = head;
		for(int i=0;i<pos-1;i++) {
			temp = temp.next;
		}
		Node temp2 = temp.next;
		temp.next = n;
		n.next = temp2;
	}
	void insertAtLast(E Data) {
		
		Node<E> n = new Node<E>(Data);
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = n;
	}
//	deleting node
	void deleteAtStrat() {
		head = head.next;
	}
	void deleteAtEnd() {
		Node temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	void deleteAtMid(int pos) {
		Node temp = head;
		Node prevNode = null;
		Node nextNode = null;
		for(int i=0;i<pos;i++) {
			prevNode = temp;
			temp = temp.next;
			nextNode = temp.next;
		}
		prevNode.next = nextNode;
	}
	void displayList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		
		LinkedListDSA<String> obj = new LinkedListDSA<String>();
		obj.insertAtStart("A");
		obj.insertAtLast("D");
		obj.insertAtMid("B",1);
		obj.insertAtMid("C",2);
		obj.insertAtMid("E",4);
		obj.insertAtLast("F");
		System.out.println("print");
		obj.displayList();
		
		System.out.println("\ndlete at start");
		obj.deleteAtStrat();
		obj.displayList();
		
		System.out.println("\ndelete at end");
		obj.deleteAtEnd();
		obj.displayList();
		
		System.out.println("\ndelete at index 2");
		obj.deleteAtMid(2);
		obj.displayList();
	}
}
