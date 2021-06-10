package com.chapter11;

public class SortedLinearSearch {

	private boolean sortedSearch(int[] arr, int key) {
		for(int i:arr) {
			if(i==key) {
				return true;
			}
			if(i>key) {
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,8,3,7,6,11,90};
		int key = 12;
		SortedLinearSearch sls = new SortedLinearSearch();
		if(sls.sortedSearch(arr, key)) {
			System.out.println("Key is Found");
		}else {
			System.out.println("Key is Not Found");
		}
	}

}
