package com.chapter7;
/*
 * Problem-1 Is there a min-heap with seven distinct elements so that the preorder traversal of it 
 * gives the elements in sorted order?
 Solution: Yes. For the tree below, preorder traversal produces ascending order.
 	
 				1
 			2		5
 		  3   4   6    7 	
 */

public class ProblemNo1 extends MinHeap{
	
	public static void main(String[] args) {
		ProblemNo1 p1 = new ProblemNo1();
		p1.insert(1);
		p1.insert(2);
		p1.insert(3);
		p1.insert(4);
		p1.insert(5);
		p1.insert(6);
		p1.insert(7);
		p1.display();
/*
 * output = [1, 2, 3, 4, 5, 6, 7] yes it is give in sorted format
 */
	}
}
