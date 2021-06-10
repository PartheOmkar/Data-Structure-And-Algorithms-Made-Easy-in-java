package com.chapter11;
/*
Problem-2 Can we improve the complexity of Problem-1’s solution?
Solution: Yes. Sort the given array. After sorting, all the elements with equal values will be
	adjacent. Now, do another scan on this sorted array and see if there are elements with the same
	value and adjacent.
 */
public class ProblemNo2 {

	private void sort(int[] arr,int low,int high) {
		if(low>high) {
			return;
		}
		int pi = partition(arr,low,high);
		sort(arr,low,pi-1);
		sort(arr,pi+1,high);
	}
	private int partition(int arr[],int low,int high) {
		
		int pivote = arr[high];
		int i=low;
		int j=low-1;
		
		while(i<=high-1) {
			
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
		
		int temp = arr[j+1];
		arr[j+1] = arr[high];
		arr[high] = temp;
	
		return j+1;
	}
	private void checkDuplicate(int[] arr) {
		sort(arr,0,arr.length-1);
		for(int i=0;i<arr.length-2;i++) {
			if(arr[i]==arr[i+1]) {
				System.out.println("duplicate value contain = "+arr[i]);
			}
		}
	}
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,6,8,9,11,12,7,8,1};
		
		ProblemNo2 p2 = new ProblemNo2();
		p2.checkDuplicate(arr);
	}
}
