package com.chapter19;
/*
Problem-35 Longest Palindrome Substring: Given a string A, we need to find the longest
	sub-string of A such that the reverse of it is exactly the same.
 */
public class ProblemNo35 {
	
	public class LPSNode{
		boolean flag=false;
		String psf="";
		public LPSNode(boolean flag,String psf) {
			this.flag = flag;
			this.psf = psf;
		}
	}
	
	public void LPS(String s) {
		LPSNode[][] dp = new LPSNode[s.length()+1][s.length()+1];
		int max = 0;
		String maxlps = "x";
		for(int gap=0;gap<s.length();gap++) {
			for(int row=0,col=gap;col<s.length();row++,col++) {
				dp[row][col] = new LPSNode(false, "X");
				if(gap==0) {
					dp[row][col] = new LPSNode(true,""+s.charAt(row));
				}else if(gap==1) {
					if(s.charAt(row)==s.charAt(col)) {
						dp[row][col] = new LPSNode(true, ""+s.charAt(row)+s.charAt(col));
					}else {
						dp[row][col] = new LPSNode(false,""+s.charAt(row)+s.charAt(col));
					}
				}else {
					if(s.charAt(row)==s.charAt(col)&&dp[row+1][col-1].flag) {
						dp[row][col] = new LPSNode(true, s.charAt(row)+dp[row+1][col-1].psf+s.charAt(col));
					}else {
						dp[row][col] = new LPSNode(false, s.charAt(row)+dp[row+1][col-1].psf+s.charAt(col));
					}
				}
				
				if(dp[row][col].flag && max<gap) {
					max = gap;
					maxlps = dp[row][col].psf;
				}
			}
		}
		for(int row=0;row<s.length();row++) {
			for(int col=0;col<s.length();col++) {
				try {
					int flag = dp[row][col].flag?0:1;
					System.out.printf("%-10s",dp[row][col].psf+"["+flag+"]");
				}catch(NullPointerException e) {
					System.out.printf("%-10s","--");
				}
				
			}
			System.out.println();
		}
		System.out.println(maxlps);
	}
	
	public static void main(String args[]) {
		ProblemNo35 p35 = new ProblemNo35();
		p35.LPS("ACGGGGCAXY");
	}
}
