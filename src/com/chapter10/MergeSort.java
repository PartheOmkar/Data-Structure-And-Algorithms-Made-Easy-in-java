package com.chapter10;

public class MergeSort {
	
	public int[] splitArray(int[] arr, int low,int high) {
		if(low>=high) {
			int[] temp = new int[1];
			temp[0] = arr[high];
			return temp;
		}
		int mid = (low+high)/2;

		int[] leftarr = splitArray(arr, low, mid);
		int[] rightarr = splitArray(arr, mid+1, high);
		int[] merge = mearge(leftarr, rightarr);
		
		return merge;
	}
	public int[] mearge(int[] leftarr, int[] rightarr) {
		int leftSize = leftarr.length;
		int rightSize = rightarr.length;
		
		int[] temp = new int[leftSize+rightSize];
		int l=0;
		int r=0;
		int k=0;
		
		while(leftSize > l && rightSize > r) {
			if(leftarr[l] < rightarr[r]) {
				temp[k] = leftarr[l];
				l++;
				k++;
			}else {
				temp[k] = rightarr[r];
				r++;
				k++;
			}
		}
		while(leftSize > l) {
			temp[k] = leftarr[l];
			l++;
			k++;
		}
		while(rightSize > r) {
			temp[k] = rightarr[r];
			r++;
			k++;
		}
		return temp;
	}
	public static void main(String[] args) {
		
		MergeSort m1 = new MergeSort();
		int arr[] = new int[]{5,9,2,4,3};
		
		arr = m1.splitArray(arr, 0, arr.length-1);
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
