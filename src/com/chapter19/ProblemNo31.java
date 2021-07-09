package com.chapter19;
/*
Problem-31 Optimal Strategy for a Game: Consider a row of n coins of values v 1 ... v n ,
	where n is even [since it’s a two player game]. We play this game with the opponent. In
	each turn, a player selects either the first or last coin from the row, removes it from the
	row permanently, and receives the value of the coin. Determine the maximum possible
	amount of money we can definitely win if we move first.
 */
public class ProblemNo31 {
	
	int[][] dp;
	int upperCount = 0;
	int count=0;
	public int game(int i,int j,int[] arr) {
		upperCount++;
		if(i==j) {
			return arr[i];
		}
		if(i>j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		count++;
		int l = arr[i]+Math.min(game(i+2,j,arr),game(i+1,j-1,arr));
		int r = arr[j]+Math.min(game(i,j-2,arr), game(i+1,j-1,arr));
		
		return dp[i][j]=Math.max(l, r);
	}
	
	public void game2(int[] arr) {
		
		for(int g=0;g<arr.length;g++) {
			for(int i=0,j =g;j<arr.length;i++,j++) {
				if(g==0) {
					dp[i][j] = arr[i];
				}
				else if(g==1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				}
				else {
					int l = arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]);
					int r = arr[j]+Math.min(dp[i+1][j-1], dp[i][j-2]);
					dp[i][j] = Math.max(l, r);
				}
			}
		}
		System.out.println(dp[0][arr.length-1]);
	}
	public static void main(String args[]) {
		int[] arr = new int[] {20,30,2,10};
		// calling recursive approach
		ProblemNo31 p31 = new ProblemNo31();
		p31.dp = new int[arr.length+1][arr.length+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				p31.dp[i][j] = -1;
			}
		}
		System.out.println(p31.game(0,arr.length-1,arr));
		
		// calling the iterative approach
		ProblemNo31 p311 = new ProblemNo31();
		p311.dp = new int[arr.length+1][arr.length+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				p311.dp[i][j] = -1;
			}
		}
		p311.game2(arr);
	}
}
