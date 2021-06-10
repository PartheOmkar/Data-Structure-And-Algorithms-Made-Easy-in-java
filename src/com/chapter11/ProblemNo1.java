package com.chapter11;
/*
 * 
Problem-1 Given an array of n numbers, give an algorithm for checking whether there are
	any duplicate elements in the array or no?
Solution: This is one of the simplest problems. One obvious answer to this is exhaustively
	searching for duplicates in the array. That means, for each input element check whether there is
	any element with the same value. This we can solve just by using two simple for loops. The code
	for this solution can be given as:
 */
public class ProblemNo1 {

	private void search(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("duplicate Value is present = "+arr[i]);
				}
			}
		}
	}
	public static void main(String[] args) {
		
		ProblemNo1 p1 = new ProblemNo1();
		int[] arr = new int[] {1,6,8,9,11,12,7,8,1};
		p1.search(arr);
	}
}
