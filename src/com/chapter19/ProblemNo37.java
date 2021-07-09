package com.chapter19;
/*
Problem-37 Given a matrix with n rows and m columns (n × m). In each cell there are a
	number of apples. We start from the upper-left corner of the matrix. We can go down or
	right one cell. Finally, we need to arrive at the bottom-right corner. Find the maximum
	number of apples that we can collect. When we pass through a cell, we collect all the
	apples left there.
 */
public class ProblemNo37 {
	public void countApples(int[][] apples) {
		int[][] dp = new int[apples.length+1][apples[0].length+1];
		for(int row=0;row<apples.length;row++) {
			dp[row][0] = apples[row][0];
		}
		for(int col=0;col<apples[0].length;col++) {
			dp[0][col] = apples[0][col];
		}
		for(int row=1;row<apples.length;row++) {
			for(int col=1;col<apples[0].length;col++) {
				dp[row][col] = Math.max(dp[row-1][col]+apples[row][col],dp[row][col-1]+apples[row][col]);
			}
		}
//		for(int row=0;row<apples.length+1;row++) {
//			for(int col=0;col<apples[0].length+1;col++) {
//				System.out.print(dp[row][col]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[apples.length-1][apples[0].length-1]);
	}
	public static void main(String args[]) {
		ProblemNo37 p37 = new ProblemNo37();
		int[][] apples = new int[3][3];
		apples[0][0] = 1; apples[0][1] = 2; apples[0][2] = 3; 
		apples[1][0] = 5; apples[1][1] = 4; apples[1][2] = 6;
		apples[2][0] = 0; apples[2][1] = 7; apples[2][2] = 2;
		
		p37.countApples(apples);
	}
}
