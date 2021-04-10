package com.Chapter2;
// Problem-2
// Given an array, check whether the array is in sorted order with recursion.

public class ProblemNo2 {
	
	private static boolean findArraySort(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(n==1) {
			return true;
		}
		
		return (arr[n-1]<arr[n-2])?false:findArraySort(arr, n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr[] = {6,2,3,4,5};
		System.out.println(findArraySort(arr,n));
		
	}

}
