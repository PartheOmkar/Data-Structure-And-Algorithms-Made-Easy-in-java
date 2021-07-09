package com.chapter18;
/*
Problem-5 Given an array, give an algorithm for finding the maximum and minimum.
 */
public class ProblemNo5 {
	
	public void quickSort(int[] arr,int min,int max,int find) {
		if(min>max) {
			return;
		}
		int pi = partition(arr, min, max);
		if(pi==find) {
			System.out.println(arr[pi]);
		}
		else if(pi > find) {
			quickSort(arr, min, pi-1,find);
		}else {
			quickSort(arr, pi+1, max,find);
		}
	}
	public int partition(int[] arr,int min,int max) {
		int pivote = arr[max];
		int i = min;
		int j = min-1;
		while(i<=max-1) {
			if(arr[i] < pivote) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}else {
				i++;
			}
		}
		int temp = arr[max];
		arr[max] = arr[j+1];
		arr[j+1] = temp;
		
		return j+1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {8,3,4,2,1,7,6,5};
		int find = 1;
		ProblemNo5 p5 = new ProblemNo5();
		p5.quickSort(arr, 0, arr.length-1,find-1);
	}
}
