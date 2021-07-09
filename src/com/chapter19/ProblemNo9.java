package com.chapter19;

import java.util.Arrays;

/*
Problem-9 :- Given a sequence of n numbers A(1) ...A(n), give an algorithm for finding a
	contiguous subsequence A(i) ...A(j) for which the sum of elements in the subsequence is
	maximum. Here the condition is we should not select two contiguous numbers.
 */
public class ProblemNo9 {
	
	int[] arr;
	int[] dp;
	public void solv() {
		arr = new int[] {5, 5, 10, 100, 10, 5};
		dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(solution(arr.length-1));
		for(int i:dp) {
			System.out.print(i+" ");
		}
	}
	public int solution(int n) {
		if(n==0) {
			dp[0] = arr[0];
			return arr[0];
		}
		if(n==1) {
			dp[1] = Math.max(arr[0], arr[1]);
			return dp[1];
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		dp[n] = Math.max(arr[n]+solution(n-2), solution(n-1));
		return dp[n];
	}
	public static void main(String[] args) {
		ProblemNo9 p9 = new ProblemNo9();
		p9.solv();
	}
}
