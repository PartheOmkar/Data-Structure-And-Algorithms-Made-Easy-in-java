package com.chapter11;

import java.util.HashMap;
import java.util.Map;

/*
Problem-3 Is there any alternative way of solving Problem-1?

Solution: Yes, using hash table. Hash tables are a simple and effective method used to implement
	dictionaries. Average time to search for an element is O(1), while worst-case time is O(n). Refer
	to Hashing chapter for more details on hashing algorithms. As an example, consider the array, A =
	{3,2,1,2,2,3}.
	Scan the input array and insert the elements into the hash. For each inserted element, keep the
	counter as 1 (assume initially all entires are filled with zeros). This indicates that the
	corresponding element has occurred already. For the given array, the hash table will look like
	(after inserting the first three elements 3,2 and 1):
 */
public class ProblemNo3 {

	private void checkDuplicate(int[] arr) {
		
		Map<Integer, Integer> duplicateTable = new HashMap<Integer, Integer>();
		for(int i:arr) {
			if(duplicateTable.containsKey(i)) {
				System.out.println("duplicate value is contain "+i);
				duplicateTable.put(i, duplicateTable.get(i)+1);
			}else {
				duplicateTable.put(i,0);
			}
		}
		for(int i:duplicateTable.keySet()) {
			System.out.println(i+" repetation = "+duplicateTable.get(i));
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,6,8,9,11,12,7,8,1};
		
		ProblemNo3 p3 = new ProblemNo3();
		p3.checkDuplicate(arr);
	}

}
