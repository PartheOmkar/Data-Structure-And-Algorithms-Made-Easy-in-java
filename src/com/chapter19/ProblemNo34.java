package com.chapter19;
/*
Problem-34 Longest Palindrome Subsequence: A sequence is a palindrome if it reads the
	same whether we read it left to right or right to left. For example A, C, G, G, G, G,C,A.
	Given a sequence of length n, devise an algorithm to output the length of the longest
	palindrome subsequence. For example, the string A,G,C,T,C,B,M,A,A,C,T,G,G,A,M has
	many palindromes as subsequences, for instance: A,G,T,C,M,C,T,G,A has length 9.
 */
public class ProblemNo34 {
	
	public void LPS(String s) {
		
		boolean[][] dp = new boolean[s.length()+1][s.length()+1];
		int max = 0;
		for(int gap=0;gap<s.length();gap++) {
			for(int row=0,col=gap;col<s.length();row++,col++) {
				if(gap==0) {
					dp[row][col] = true;
				}else if(gap==1) {
					dp[row][col] = s.charAt(row)==s.charAt(col);
				}else {
					dp[row][col] = s.charAt(row)==s.charAt(col) && dp[row+1][col-1];
				}
				
				max = dp[row][col]&&gap>max?gap:max;
			}
		}
		for(int row=0;row<s.length();row++) {
			for(int col=0;col<s.length();col++) {
				System.out.print(dp[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println(max+1);
	}
	public static void main(String args[]) {
		ProblemNo34 p34 = new ProblemNo34();
		p34.LPS("ACGGGGCA");
	}
}
