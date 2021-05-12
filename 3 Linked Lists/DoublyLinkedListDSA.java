package com.chapter3;

public class DoublyLinkedListDSA<E> {
	
	private class Node<E>{
		E data;
		Node next;
		Node prev;
		
		public Node(E data) {
			super();
			this.data = data;
		}
	}
	private Node head;
	private Node tail;
	
	void insertAtFirst(E data) {
		Node<E> n = new Node<E>(data);
//		if list is empty then create first node.
		if(head==null) {
			n.next = head;
			head = n;
			head.prev = null;
			tail = head;
		}
//		if list is not empty then insert Node at first position.
		else {
			head.prev = n;
			n.next = head;
			head = n;
			head.prev = null;
		}
	}
	
	void inserdAtMid(E data, int pos) {
		Node<E> n = new Node<E>(data);
		Node temp = head;
//		what if list is empty and you try to insert.
		if(temp==null) {
			insertAtFirst(data);
			return;
		}
		for(int i=0;i<pos-1;i++) {
			temp = temp.next;
		}
//		what if the given position is exist at the End of list.
		if(temp.next==null) {
			insertAtEnd(data);
			return;
		}
//		insert at mid
		Node temp2 = temp.next;
		temp.next = n;
		n.prev = temp;
		n.next = temp2;
		temp2.prev = n;
		
	}
	
	void insertAtEnd(E data) {
		Node<E> n = new Node<E>(data);
		Node temp = tail;
//		what if list is empty and you try to insert at end.
		if(temp==null) {
			insertAtFirst(data);
			return;
		}
//		insert at end using tail pointer.
		tail.next = n;
		n.prev = tail;
		tail = n;
	}

/*
 * Perform delete operation on list
 * 1. deleteAtFirst()
 * 2. deleteAtMid(index)
 * 2. deleteAtEnd()
 */
	void deleteAtFirst() {
//		what if list contain only one node.
		if(head.next==null) {
			head = null;
			tail = null;
		}
//		what if list contain more than one node.
		else {
			head = head.next;
			head.prev = null;
		}
	}
	
	void deleteAtMid(int pos) {
		
		Node temp = head;
//		what if we try to delete first node.
		if(pos==0) {
			deleteAtFirst();
			return;
		}
//		iteration to get on given position.
		for(int i=0;i<pos-1;i++) {
			temp = temp.next;
		}
//		if the given position is exist at the END
		if(temp.next.next==null) {
			deleteAtEnd();
			return;
		}
//		delete at given position.
		Node temp2 = temp.next.next;
		temp.next = temp2;
		temp2.prev = temp;
	}
	
	void deleteAtEnd() {
//		what if the only one node is present in the list.
		if(tail.prev==null) {
			tail = null;
			head = null;
		}
//		delete the last node.
		else {
			Node temp = tail.prev;
			tail = temp;
			temp.next = null;
		}
	}
/*
 * display List 
 * 1. displayListFromHead() :- display list from head (start -> end)
 * 2. displayListFromTail() :- display list from tail (end -> start)
 */
	void displayListFromHead(){
		
		Node temp = head;
		if(temp == null) {
			System.out.println("List Is Empty");
			return;
		}
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	void displayListFromTail() {
		Node temp = tail;
		if(tail==null) {
			System.out.println("List is Empty");
		}
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedListDSA<Integer> ddl = new DoublyLinkedListDSA<Integer>();
		ddl.inserdAtMid(5, 1);
		ddl.insertAtEnd(6);
		ddl.deleteAtMid(0);
		System.out.println("\nDisplay From head = ");
		ddl.displayListFromHead();
		System.out.println("\nDisplay From tail = ");
		ddl.displayListFromTail();
		
//		ddl.deleteAtFirst();
//		
//		ddl.displayListFromHead();
//		System.out.println("\ndisplay from tail");
//		ddl.displayListFromTail();
//		System.out.println();
//		ddl.displayListFromTail();
		

	}

}
