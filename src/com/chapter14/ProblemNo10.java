package com.chapter14;
/*
Problem-10 Given an array of 101 elements. Out of them 50 elements are distinct, 24
	elements are repeated 2 times, and one element is repeated 3 times. Find the element that is
	repeated 3 times in O(1).
Solution: Using Hash Tables
	Algorithm:
	• Scan the input array one by one.
	• Check if the element is already there in the hash table or not.
	• If it is already there in the hash table, increment its counter value [this indicates the
	  number of occurrences of the element].
	• If the element is not there in the hash table, insert that node into the hash table with
	  counter value 1.
	• Continue this process until reaching the end of the array.
	
Time Complexity: O(n), because we are doing two scans. Space Complexity: O(n), for hash
table.
 */
public class ProblemNo10 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1,1,1,6,6,6,6,2,2,2};
		HashMapDS<Integer, Integer> output = new HashMapDS<Integer, Integer>();
		for(int i:arr) {
			if(output.containKey(i)) {
				output.put(i, output.getValue(i)+1);
			}else {
				output.put(i, 1);
			}
		}
		for(int k:output.keyset()) {
			System.out.println("Integer = "+k+" repeated "+output.getValue(k)+" times");
		}
	}
}
