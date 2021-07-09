package com.chapter19;
/*
Problem-20 :- Longest Increasing Subsequence: Given a sequence of n numbers A 1 . . .A n ,
	determine a subsequence (not necessarily contiguous) of maximum length in which the
	values in the subsequence form a strictly increasing sequence.
 */
public class ProblemNo20 {
	private class LISNode{
		int value;
		String path;
		public LISNode(int value,String path) {
			this.value = value;
			this.path = path; 
		}
	}
	
	public void LIS(int arr[]) {
		LISNode[] dp = new LISNode[arr.length];
		
		for(int i=0;i<dp.length;i++) {
			dp[i] = new LISNode(1,""+arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i].value < dp[j].value+1) {
					dp[i].value = dp[j].value+1;
					dp[i].path = dp[j].path+" "+arr[i];
				}
			}
		}
		int max=Integer.MIN_VALUE;
		LISNode maxnode = null;
		for(LISNode node:dp) {
			if(max<node.value) {
				maxnode = node;
				max = node.value;
			}
		}
		System.out.println("Max sequence = "+maxnode.value+"\n"+maxnode.path);
	}
	public static void main(String args[]) {
		int[] arr = new int[] {5,6,2,3,4,9,8,9,5};
		ProblemNo20 p20 = new ProblemNo20();
		p20.LIS(arr);
	}
}
