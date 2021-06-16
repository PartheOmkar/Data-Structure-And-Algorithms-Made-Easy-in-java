package com.chapter14;

import java.util.ArrayList;

/*
Problem-5 Given two arrays of unordered numbers, check whether both arrays have the same set of numbers?
Solution: Let us assume that two given arrays are A and B. A simple solution to the given
	problem is: for each element of A, check whether that element is in B or not. A problem arises
	with this approach if there are duplicates. For example consider the following inputs:
		
		A = {2,5,6,8,10,2,2}
		B = {2,5,5,8,10,5,6}
	The above algorithm gives the wrong result because for each element of A there is an element in
	B also. But if we look at the number of occurrences, they are not the same. This problem we can
	solve by moving the elements which are already compared to the end of the list. That means, if we
	find an element in B, then we move that element to the end of B, and in the next searching we will
	not find those elements. But the disadvantage of this is it needs extra swaps. Time Complexity of
	this approach is O(n 2 ), since for each element of A we have to scan B.
 */
public class ProblemNo5 {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{2,5,6,8,10,2,2};
	    int[] arr2 = new int[]{2,5,5,8,10,5,6};
	    int arr2len = arr2.length-1;
	    ArrayList<Integer> output = new ArrayList<Integer>();
	    for(int i=0;i<arr1.length;i++) {
	    	for(int j=0;j<=arr2len;j++) {
	    		if(arr1[i]==arr2[j]) {
	    			output.add(arr2[j]);
	    			int temp = arr2[j];
	    			arr2[j] = arr2[arr2len];
	    			arr2[arr2len] = temp;
	    			arr2len--;
	    			break;
	    		}
	    	}
	    }
	    System.out.println(output);
	}
}
