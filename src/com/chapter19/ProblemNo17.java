package com.chapter19;
/*
Problem-17 Integer Knapsack Problem [Duplicate Items Permitted]: Given n types of
	items, where the i th item type has an integer size s i and a value v i . We need to fill a
	knapsack of total capacity C with items of maximum value. We can add multiple items of
	the same type to the knapsack.
	
	DUPLICATE ITEM'S ARE ALLOW:
 */
public class ProblemNo17 {
	public void knapsack(int[] profit,int[] weight,int capacity) {
		int[] dp = new int[capacity+1];
		dp[0]=0;
		for(int i=1;i<capacity+1;i++) {
			
			int max=0;
			for(int j=0;j<weight.length-1;j++) {
				if(i>=weight[j]) {
					max = Math.max(max, dp[i-weight[j]]+profit[j]);
				}
			}
			dp[i] = Math.max(max, dp[i-1]);
		}
		for(int d:dp) {
			System.out.print(d+" ");
		}
		System.out.println(dp[capacity]);
	}
	public static void main(String[] args) {
		int[] profit = new int[] {15,14,10,45,50};
		int[] weight = new int[] {2,5,1,3,4};
		int capacity = 7;
		ProblemNo17 p17 = new ProblemNo17();
		p17.knapsack(profit,weight,capacity);
	}
}
