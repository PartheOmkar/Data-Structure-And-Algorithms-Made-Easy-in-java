package com.chapter19;

public class ProblemNo33 {
	public void minEditDistance(String a,String b) {
		int[][] dp = new int[b.length()+1][a.length()+1];
		for(int row=0;row<b.length()+1;row++) {
			dp[row][0] = row;
		}
		for(int col=0;col<a.length()+1;col++) {
			dp[0][col] = col;
		}
		
		for(int row=1;row<b.length()+1;row++) {
			for(int col=1;col<a.length()+1;col++) {
				if(b.charAt(row-1)==a.charAt(col-1)) {
					int insert = dp[row-1][col];
					int delete = dp[row][col-1];
					int replace = dp[row-1][col-1];
					
					dp[row][col] = Math.min(Math.min(insert, delete), replace);
				}else {
					int insert = dp[row-1][col]+1;
					int delete = dp[row][col-1]+1;
					int replace = dp[row-1][col-1]+1;
					
					dp[row][col] = Math.min(Math.min(insert, delete), replace);
				}
			}
		}
		for(int row=0;row<b.length()+1;row++) {
			for(int col=0;col<a.length()+1;col++) {
				System.out.print(dp[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("Answer is = "+dp[b.length()][a.length()]);
	}
	public static void main(String args[]) {
		String a = "EXECUTION";// main string
		String b = "INTENTION";// to convert
		ProblemNo33 p33 = new ProblemNo33();
		p33.minEditDistance(a, b);
	}
}
