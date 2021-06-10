package com.chapter11;

public class BinarySearch {

	private int bSearch(int[] arr,int key,int low,int high) {
		System.out.println("count");
		if(low > high) {
			System.out.println("key is not found");
			return 1;
		}
		
		int mid = (low+high)/2;
		if(arr[mid]==key) {
			System.out.println("key is found");
			return 0;
		}
		
		if(arr[mid] < key) {
			return bSearch(arr, key, mid+1, high);
		}else {
			return bSearch(arr, key, low, mid-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int key = 12;
		
		BinarySearch bs = new BinarySearch();
		bs.bSearch(arr, key, 0, arr.length-1);
	}

}
