package com.chapter19;
/*
Problem-39 Maximum size square sub-matrix with all l’s: Given a matrix with 0’s and 1’s,
	give an algorithm for finding the maximum size square sub-matrix with all Is. For example,
	consider the binary matrix below.
		0 1 1 0 1
		1 1 0 1 0
		0 1 1 1 0
		1 1 1 1 0
		1 1 1 1 1
		0 0 0 0 0
 */
public class ProblemNo39 {
	public void findMatrix(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int row=0;row<matrix.length;row++) {
			dp[row][0] = matrix[row][0];
		}
		for(int col=0;col<matrix[0].length;col++) {
			dp[0][col] = matrix[0][col];
		}
		int max = Integer.MIN_VALUE;
		int i=0,j=0;
		for(int row=1;row<matrix.length;row++) {
			for(int col=1;col<matrix[0].length;col++) {
				if(matrix[row][col]==1) {
					dp[row][col] = Math.min(Math.min(dp[row-1][col-1], dp[row-1][col]), dp[row][col-1])+1;
					if(max<dp[row][col]) {
						max = dp[row][col];
						j = row;
						i = col;
					}
				}else {
					dp[row][col] = 0;
				}
			}
		}
		int endi=i,endj=j;
		while(dp[j][i]!=1){
			i = i-1;
			j = j-1;
		}
		for(int row=j;row<=endj;row++) {
			for(int col=i;col<=endi;col++) {
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		int[][] matrix = new int[][] {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		ProblemNo39 p39 = new ProblemNo39();
		p39.findMatrix(matrix);
	}
}
