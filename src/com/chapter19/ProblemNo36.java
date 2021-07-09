package com.chapter19;
/*
Problem-36 Given two strings S and T, give an algorithm to find the number of times S
	appears in T. It’s not compulsory that all characters of S should appear contiguous to T.
	For example, if S = ab and T = abadcb then the solution is 4, because ab is appearing 4
	times in abadcb.
 */
public class ProblemNo36 {
	public void countSubstring(String a,String b) {
		int[][] dp = new int[b.length()+1][a.length()+1];
		
		for(int col=0;col<=a.length();col++) {
			dp[0][col] = 1;
		}
		for(int row=0;row<=b.length();row++) {
			dp[row][0] = 0;
		}
		
		for(int row=1;row<=b.length();row++) {
			for(int col=1;col<=a.length();col++) {
				if(b.charAt(row-1)==a.charAt(col-1)) {
					dp[row][col] = dp[row-1][col-1]+1; //dp[row-1][col-1];
				}else {
					dp[row][col] = dp[row][col-1];
				}
			}
		}
		
		for(int row=0;row<b.length()+1;row++) {
			for(int col=0;col<a.length()+1;col++) {
				System.out.print(dp[row][col]);
			}
			System.out.println();
		}
		System.out.println(dp[b.length()][a.length()]);
	}
	public static void main(String args[]) {
		String a = "abadcb";
		String b = "ab";
		ProblemNo36 p36 =new ProblemNo36();
		p36.countSubstring(a, b);
	}
}
