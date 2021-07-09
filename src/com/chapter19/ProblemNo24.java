package com.chapter19;

import java.util.Arrays;
import java.util.Comparator;
/*
Problem-24 Building Bridges in India: Consider a very long, straight river which moves
	from north to south. Assume there are n cities on both sides of the river: n cities on the left
	of the river and n cities on the right side of the river. Also, assume that these cities are
	numbered from 1 to n but the order is not known. Now we want to connect as many left-
	right pairs of cities as possible with bridges such that no two bridges cross. When
	connecting cities, we can only connect city i on the left side to city i on the right side.
 */
public class ProblemNo24 {
	
	private class BridgeNode{
		int n;
		int s;
		public BridgeNode(int n,int s) {
			this.n = n;
			this.s = s;
		}
	}
	
	private class BridgeSort implements Comparator<BridgeNode>{
		public int compare(BridgeNode arg0, BridgeNode arg1) {
			return arg0.n-arg1.n;
		}
	}
	
	public void createBridge(int[] north,int[] south) {
		
		BridgeNode[] arr = new BridgeNode[north.length];
		
		for(int i=0;i<north.length;i++) {
			arr[i] = new BridgeNode(north[i], south[i]);
		}
		Arrays.sort(arr,new BridgeSort());
		
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp,1);
		
		for(int i=0;i<north.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i].s > arr[j].s) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i:dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
	
	public static void main(String args[]) {
		int[] north = new int[] {10,2,8,17,21,50,41,60,80,1};
		int[] south = new int[] {20,7,15,3,40,4,57,80,90,30};
		ProblemNo24 p24 = new ProblemNo24();
		p24.createBridge(north, south);
	}
}
