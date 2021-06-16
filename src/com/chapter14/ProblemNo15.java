package com.chapter14;
/*
Problem-15 Can we improve the time complexity of 0?

Solution: Yes. By using hash tables we can reduce the time complexity. Create a hash table by
	reading all the characters in the input string and keeping count of the number of times each
	character appears. After creating the hash table, we can read the hash table entries to see which
	element has a count equal to 1. This approach takes O(n) space but reduces the time complexity
	also to O(n).

Time Complexity; We have O(n) to create the hash table and another O(n) to read the entries of
hash table. So the total time is O(n) + O(n) = O(2n) ≈ O(n). Space Complexity: O(n) for keeping
the count values.
 */
public class ProblemNo15 {
	
	public static void main(String[] args) {
		String str = "abzddab";
		HashMapDS<Character, Integer> output = new HashMapDS<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(output.containKey(str.charAt(i))) {
				output.put(str.charAt(i), output.getValue(str.charAt(i))+1);
			}else {
				output.put(str.charAt(i), 1);
			}
		}
		for(int i=0;i<str.length();i++) {
			if(output.getValue(str.charAt(i))==1) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}
}
