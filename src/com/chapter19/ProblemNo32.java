package com.chapter19;

import java.util.Arrays;
/*
Problem-32 Tiling: Assume that we use dominoes measuring 2 × 1 to tile an infinite strip of
	height 2. How many ways can one tile a 2 × n strip of square cells with 1 × 2 dominoes?
 */
public class ProblemNo32 {
	int[] dp ;
	public int tiling(int n) {
		if(dp[n]!=-1) {
			return dp[n];
		}
		return dp[n] = tiling(n-1)+tiling(n-2);
	}
	public static void main(String args[]) {
		ProblemNo32 p32 = new ProblemNo32();
		int n = 4;
		p32.dp = new int[n+1];
		Arrays.fill(p32.dp, -1);
		p32.dp[2] = 2;
		p32.dp[1] = 1;
		p32.dp[0] = 0;
		System.out.println(p32.tiling(n));
	}
}
