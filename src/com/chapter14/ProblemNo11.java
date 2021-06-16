package com.chapter14;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
Problem-11 Given m sets of integers that have n elements in them, provide an algorithm to
	find an element which appeared in the maximum number of sets?
Solution: Using Hash Tables
	Algorithm:
	• Scan the input sets one by one.
	• For each element keep track of the counter. The counter indicates the frequency of
	• occurrences in all the sets.
		After completing the scan of all the sets, select the one which has the maximum
		counter value.
		
Time Complexity: O(mn), because we need to scan all the sets. Space Complexity: O(mn), for
hash table. Because, in the worst case all the elements may be different.
 */
public class ProblemNo11 {
	
	public static void main(String[] args) {
		ArrayList<Set<Integer>> sets = new ArrayList<Set<Integer>>();
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1); set1.add(2); set1.add(3); set1.add(1); set1.add(4); set1.add(5);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(4);set2.add(3);set2.add(6);set2.add(8);set2.add(1);
		sets.add(set1);
		sets.add(set2);
		HashMapDS<Integer, Integer> output = new HashMapDS<Integer, Integer>();
		
		for(Set<Integer> i:sets) {
			for(Integer v:i) {
				if(output.containKey(v)) {
					output.put(v, output.getValue(v)+1);
				}else {
					output.put(v,1);
				}
			}
			
		}
		for(Integer k:output.keyset()) {
			System.out.println("Integer = "+k+" repeated "+output.getValue(k)+" times");
		}
	}
}
