package com.chapter7;
/*
 * Problem-2 Is there a max-heap with seven distinct elements so that the preorder traversal of
	it gives the elements in sorted order?
Solution: Yes. For the tree below, preorder traversal produces descending order.
				7
			6		5
		4	   3 2		1	
 */
public class ProblemNo2 {
	public static void main(String[] args) {
		MaxHeap mp = new MaxHeap();
		mp.insert(7);
		mp.insert(6);
		mp.insert(5);
		mp.insert(4);
		mp.insert(3);
		mp.insert(2);
		mp.insert(1);
		mp.display();
//		output of this code is :- [7, 6, 5, 4, 3, 2, 1]
	}
}
