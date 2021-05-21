package com.chapter7;
/*
 * Problem-7 :- Given a min-heap, give an algorithm for finding the maximum element.
Solution: For a given min heap, the maximum element will always be at leaf only. Now, the next
	question is how to find the leaf nodes in the tree. If we carefully observe, the next node of the last
	element’s parent is the first leaf node. Since the last element is always at the h → count – 1 th
	location, the next node of its parent (parent at location (h->count-1)/2) can be calculated as:
	Now, the only step remaining is scanning the leaf nodes and finding the maximum among them.
 */
import java.util.ArrayList;

public class ProblemNo7 extends MinHeap{

	
	public int findMinHeap(ArrayList<Integer> heap) {
		
		int Max = -1;
		for(int i=heap.size()/2;i<heap.size()-1;i++) {
			if(heap.get(i)>Max) {
				Max = heap.get(i);
			}
		}
		return Max;
	}
	
	public static void main(String[] args) {
		
		MinHeap mn = new MinHeap();
		mn.insert(1);
		mn.insert(5);
		mn.insert(14);
		mn.insert(2);
		mn.insert(10);
		mn.insert(21);
		mn.insert(18);
		mn.insert(3);
		mn.insert(11);
		mn.insert(8);
		mn.insert(7);
		mn.insert(12);
		mn.display();
		
		ProblemNo7 p7 = new ProblemNo7();
		System.out.println(p7.findMinHeap(mn.minheap));
	}
}
