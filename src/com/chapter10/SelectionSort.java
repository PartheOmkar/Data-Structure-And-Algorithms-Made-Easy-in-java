package com.chapter10;

public class SelectionSort {
	
	public static void main(String[] args) {
		System.out.println("insertion sort");
		int array[] = new int[]{5,9,10,40,50,2,3,4};
		
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for(int i:array) {
			System.out.print(i+" ");
		}
	}
}
