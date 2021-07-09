package com.chapter19;
/*
Problem :- Maximum Value Contiguous Subsequence: Given an array of n numbers, give
	an algorithm for finding a contiguous subsequence A(i)... A(j) for which the sum of
	elements is maximum. Example: {-2, 11, -4, 13, -5, 2} → 20 and {1, -3, 4, -2, -1, 6} → 7
 */
public class ProblemNo6 {
	public void solution(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int maxSum = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++) {
			int temp = Math.max(arr[i], dp[i-1]+arr[i]);
			dp[i] = temp;
			maxSum = maxSum<temp?temp:maxSum;
		}
		System.out.println(maxSum);
	}
	public static void main(String[] args) {
		ProblemNo6 p6 = new ProblemNo6();
		int[] arr = new int[] {1, -3, 4, -2, -1, 6};
		p6.solution(arr);
	}
}
