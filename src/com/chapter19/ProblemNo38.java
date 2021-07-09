package com.chapter19;
/*
Problem-38 Similar to Problem-37, assume that we can go down, right one cell, or even in a
	diagonal direction. We need to arrive at the bottom-right corner. Give DP solution to find
	the maximum number of apples we can collect.
 */
public class ProblemNo38 {
	public void countApples(int[][] apples) {
		int[][] dp = new int[apples.length][apples[0].length];
		
		for(int row=0;row<apples.length;row++) {
			dp[row][0] = apples[row][0];
		}
		for(int col=0;col<apples[0].length;col++) {
			dp[0][col] = apples[0][col];
		}
		for(int row=1;row<apples.length;row++) {
			for(int col=1;col<apples[0].length;col++) {
				dp[row][col] = Math.max(Math.max(dp[row-1][col], dp[row][col-1]), dp[row-1][col-1])+apples[row][col];
			}
		}
		for(int row=0;row<apples.length;row++) {
			for(int col=0;col<apples[0].length;col++) {
				System.out.printf("%-10s",dp[row][col]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		ProblemNo38 p38 = new ProblemNo38();
		int[][] apples = new int[3][3];
		apples[0][0] = 1; apples[0][1] = 2; apples[0][2] = 3; 
		apples[1][0] = 5; apples[1][1] = 4; apples[1][2] = 6;
		apples[2][0] = 0; apples[2][1] = 7; apples[2][2] = 2;
		p38.countApples(apples);
	}
}
