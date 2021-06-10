package com.chapter10;

public class QuickSort {

	public void quickSort(int[] arr, int low,int high){
		if(low > high) {
			return;
		}
		int pi = partition(arr, low, high);
		quickSort(arr, low, pi-1);
		quickSort(arr, pi+1, high);
	}
	public int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];

		int i=low;
		int j=low-1;
		
		while(i<=high-1) {
			if(arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				
			}else {
				i++;
			}
		}
		int temp = arr[j+1];
		arr[j+1] = arr[high];
		arr[high] = temp;
		
		return j+1;
	}
	
	public static void main(String[] args) {
		
		QuickSort qc = new QuickSort();
		int arr[] = new int[]{5,9,2,4,3};
		
		qc.quickSort(arr, 0, arr.length-1);
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
