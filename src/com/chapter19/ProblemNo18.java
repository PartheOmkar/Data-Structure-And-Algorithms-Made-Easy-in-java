package com.chapter19;
/*
Problem-18 0-1 Knapsack Problem: For Problem-17, how do we solve it if the items are
	not duplicated (not having an infinite number of items for each type, and each item is
	allowed to be used for 0 or 1 time)?
Real-time example: Suppose we are going by flight, and we know that there is a
	limitation on the luggage weight. Also, the items which we are carrying can be of different
	types (like laptops, etc.). In this case, our objective is to select the items with maximum
	value. That means, we need to tell the customs officer to select the items which have more
	weight and less value (profit).
 */
public class ProblemNo18 {
	
	private void knapsack(int[] profit, int[] weight,int capacity) {
		
		int[][] dp = new int[capacity+1][profit.length+1];
		
		for(int i=0;i<capacity+1;i++) {
			dp[i][0] = 0;
		}
		for(int i=0;i<profit.length+1;i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1;i<profit.length+1;i++) {
			for(int j=1;j<capacity+1;j++) {
				if(j>=weight[i-1]) {
					dp[j][i] = Math.max(dp[j][i-1], dp[j-weight[i-1]][i-1]+profit[i-1]);
				}else {
					dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
				}
			}
		}
		System.out.println(dp[capacity][profit.length]);
	}
	public static void main(String[] args) {
		
		int[] profit = new int[] {10,12,16};
		int[] weight = new int[] {1,2,3};
		int capacity = 10;
		
		ProblemNo18 p18 = new ProblemNo18();
		p18.knapsack(profit,weight,capacity);
	}
}
