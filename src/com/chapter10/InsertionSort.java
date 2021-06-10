package com.chapter10;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int arr[] = new int[]{5,9,10,40,50,2,3,4};
		
		for(int i=0;i<arr.length;i++) {
			int j=i;
			int v = arr[i];
			while(j >=1 && arr[j-1] > v) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = v;
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
