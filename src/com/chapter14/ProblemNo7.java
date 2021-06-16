package com.chapter14;

import java.util.ArrayList;

/*
Problem-7 Can we further improve the time complexity of Problem-5?
Solution: Yes, by using a hash table. For this, consider the following algorithm.
	Algorithm:
	• Construct the hash table with array A elements as keys.
	• While inserting the elements, keep track of the number frequency for each number.
	  That means, if there are duplicates, then increment the counter of that corresponding
	  key.
	• After constructing the hash table for A’s elements, now scan the array B.
	• For each occurrence of B’s elements reduce the corresponding counter values.
	• At the end, check whether all counters are zero or not.
	• If all counters are zero, then both arrays are the same otherwise the arrays are
		different.
Time Complexity: O(n) for scanning the arrays. Space Complexity; O(n) for hash table.
 */
public class ProblemNo7 {
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[]{2,5,6,8,10,2,2};
		int[] arr2 = new int[]{2,5,5,8,10,5,6};
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMapDS<Integer, Integer> temp = new HashMapDS<Integer, Integer>();
		for(int i=0;i<arr1.length;i++) {
			if(temp.containKey(arr1[i])) {
				temp.put(arr1[i],temp.getValue(arr1[i])+1);
			}else {
				temp.put(arr1[i], 0);
			}
		}
		for(int i=0;i<arr2.length;i++) {
			if(temp.containKey(arr2[i])&&temp.getValue(arr2[i])>=0) {
				output.add(arr2[i]);
				temp.put(arr2[i],temp.getValue(arr2[i])-1);
			}
		}
		System.out.println(output);
	}
	
}
