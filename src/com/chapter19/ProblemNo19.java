package com.chapter19;

public class ProblemNo19 {
	public void coinChange(int[] denomination,int value) {
		int[] dp = new int[value+1];
		dp[0] = 0;
		for(int i=1;i<value+1;i++) {
			int min = Integer.MAX_VALUE;
			for(int coin:denomination) {
				if(i>=coin) {
					min = Math.min(min, dp[i-coin]+1);
				}else {
					break;
				}
			}
			dp[i] = min;
		}
		System.out.println(dp[value]);
	}
	public static void main(String args[]) {
		int[] denomination = new int[] {1,2,5,10,20,50,100,500,2000};
		int value = 40;
		ProblemNo19 p19 = new ProblemNo19();
		p19.coinChange(denomination, value);
	}
}
