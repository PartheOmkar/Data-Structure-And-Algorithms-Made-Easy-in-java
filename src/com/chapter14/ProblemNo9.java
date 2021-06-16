package com.chapter14;
/*
Problem-9 Given a singly linked list, check whether it has a loop in it or not.

Solution: Using Hash Tables
	Algorithm:
	• Traverse the linked list nodes one by one.
	• Check if the node’s address is there in the hash table or not.
	• If it is already there in the hash table, that indicates we are visiting a node which was
	  already visited. This is possible only if the given linked list has a loop in it.
	• If the address of the node is not there in the hash table, then insert that node’s address
	  into the hash table.
	• Continue this process until we reach the end of the linked list or we find the loop.
	
Time Complexity: O(n) for scanning the linked list. Note that we are doing a scan only of the
input. Space Complexity; O(n) for hash table.
 */
public class ProblemNo9 {
	
	public static void main(String[] args) {
		
	}
}
