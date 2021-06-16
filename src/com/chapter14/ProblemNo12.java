package com.chapter14;

import java.util.ArrayList;

/*
Problem-12 Given two sets A and B, and a number K, Give an algorithm for finding whether
	there exists a pair of elements, one from A and one from B, that add up to K.
Solution: For simplicity, let us assume that the size of A is m and the size of B is n.
	Algorithm:
	• Select the set which has minimum elements.
	• For the selected set create a hash table. We can use both key and value as the same.
	• Now scan the second array and check whether (K-selected element) exists in the
	  hash table or not.
	• If it exists then return the pair of elements.
	• Otherwise continue until we reach the end of the set.
	
Time Complexity: O(Max(m,n)), because we are doing two scans. Space Complexity:
O(Min(m,n)), for hash table. We can select the small set for creating the hash table.
 */
public class ProblemNo12 {
	private static class Pair{
		int num1;
		int num2;
		public Pair(int num1,int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}
	public static void main(String[] args) {
		int[] arr1 = new int[] {2,5,6,8,10,2,2};
		int[] arr2 = new int[] {2,5,5,8,10,5,4,0};
		int k = 10;
		HashMapDS<Integer, Integer> set1 = new HashMapDS<Integer, Integer>();
		ArrayList<Pair> output = new ArrayList<Pair>();
		
		for(Integer i:arr1.length>arr2.length?arr2:arr1) {
			set1.put(i, i);
		}
		for(int j:arr1.length>arr2.length?arr1:arr2) {
			if(j>k) {
				continue;
			}else {
				int temp = k-j;
				if(set1.containKey(temp)) {
					output.add(new Pair(j,temp));
				}
			}
		}
		for(Pair p:output) {
			System.out.print("{ "+p.num1+", "+p.num2+" }, ");
		}
	}
}
