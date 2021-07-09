package com.chapter19;

public class ProblemNo25 {
	public void sumOfSubset(int[] arr,int n,int t) {
		boolean[][] dp = new boolean[t+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<t+1;j++) {
				if(arr[i-1]<=j) {
					if(arr[i-1] == j || dp[j-arr[i-1]][i-1] || dp[j][i-1]) {
						dp[j][i] = true;
					}else {
						dp[j][i] = false;
					}
				}
			}
		}
		// row
		for(int i=0;i<n+1;i++) {
			// column
			for(int j=0;j<t+1;j++) {
				System.out.print(dp[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[t][n]);
	}
	public static void main(String args[]) {
		int[] arr = new int[] {2,1};
		ProblemNo25 p25 = new ProblemNo25();
		p25.sumOfSubset(arr, arr.length, 5);
	}
}
