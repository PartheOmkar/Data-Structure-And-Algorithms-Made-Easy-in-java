package com.chapter14;
/*
Problem-8 Given a list of number pairs; if pair(i,j) exists, and pair(j,i) exists, report all such
	pairs. For example, in {{1,3},{2,6},{3,5},{7,4},{5,3},{8,7}}, we see that {3,5} and
	{5,3} are present. Report this pair when you encounter {5,3}. We call such pairs
	‘symmetric pairs’. So, give an efficient algorithm for finding all such pairs.
Solution: By using hashing, we can solve this problem in just one scan. Consider the following
	algorithm.
Algorithm:
	• Read the pairs of elements one by one and insert them into the hash table. For each
	  pair, consider the first element as key and the second element as value.
	• While inserting the elements, check if the hashing of the second element of the current
	  pair is the same as the first number of the current pair.
	• If they are the same, then that indicates a symmetric pair exits and output that pair.
	• Otherwise, insert that element into that. That means, use the first number of the
	  current pair as key and the second number as value and insert them into the hash table.
	• By the time we complete the scanning of all pairs, we have output all the symmetric pairs.
	
Time Complexity: O(n) for scanning the arrays. 
Note that we are doing a scan only of the input.Space Complexity; O(n) for hash table.
 */
import java.util.ArrayList;

public class ProblemNo8 {
	private static class Pair{
		int num1;
		int num2;
		public Pair(int num1,int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}
	public static void main(String[] args) {
		
		ArrayList<Pair> arr = new ArrayList<ProblemNo8.Pair>();
		arr.add(new Pair(1,3));
		arr.add(new Pair(2,6));
		arr.add(new Pair(3,5));
		arr.add(new Pair(7,4));
		arr.add(new Pair(5,3));
		arr.add(new Pair(8,7));
		
		HashMapDS<Integer, Integer> output = new HashMapDS<Integer, Integer>();
		ArrayList<Pair> answer = new ArrayList<ProblemNo8.Pair>();
		for(Pair p:arr) {
			if(output.containKey(p.num1) && output.getValue(p.num1)==p.num2 || output.containKey(p.num2)&&output.getValue(p.num2)==p.num1) {
				answer.add(new Pair(p.num1,p.num2));
			}else {
				output.put(p.num1, p.num2);
			}
		}
		for(Pair p: answer) {
			System.out.print("{"+p.num1+" "+p.num2+"} ");
		}
	}
}
