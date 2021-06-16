package com.chapter14;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem-6 Can we improve the time complexity of Problem-5?
Solution: Yes. To improve the time complexity, let us assume that we have sorted both the lists.
	Since the sizes of both arrays are n, we need O(n log n) time for sorting them. After sorting, we
	just need to scan both the arrays with two pointers and see whether they point to the same element
	every time, and keep moving the pointers until we reach the end of the arrays.
	Time Complexity of this approach is O(n log n). This is because we need O(n log n) for sorting
	the arrays. After sorting, we need O(n) time for scanning but it is less compared to O(n log n).
 */
public class ProblemNo6 {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{2,5,6,8,10,2,2};
		int[] arr2 = new int[]{2,5,5,8,10,5,6};
		ArrayList<Integer> output = new ArrayList<Integer>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i=0;
		int j=0;
		while(i<arr1.length) {
			if(arr1[i]==arr2[j]) {
				output.add(arr1[i]);
				i++;
				j++;
				//continue;
			}
			else if(arr1[i]>arr2[j]) {
				j++;
			}
			//(arr1[i]<arr2[j]) 
			else{
				i++;
			}
		}
		System.out.println(output);
	}
}
