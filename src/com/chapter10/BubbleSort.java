package com.chapter10;

public class BubbleSort {
	
	public static void main(String[] args) {
		int array[] = new int[]{5,9,10,40,50,2,3,4}; 
		int count =1 ;
		
		while(count<array.length) {
			for(int i=0;i<array.length-count;i++) {
				if(array[i]>array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			count++;
		}
		
		for(int i:array) {
			System.out.print(i+" ");
		}
	}
}
