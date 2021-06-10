package com.chapter11;

public class LinearSearch {
	
	public boolean lSearch(int[] arr, int key) {
		
		for(int i:arr) {
			if(i==key) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,8,3,7,6,11,90};
		int key = 12;
		LinearSearch ls = new LinearSearch();
		if(ls.lSearch(arr, key)) {
			System.out.println("Key is Found");
		}else {
			System.out.println("Key is Not Found");
		}
	}
}
