package com.chapter19;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public long getWay(int n,List<Long> c) {
		long[] dp = new long[n+1];
		dp[0]=1;
		for(long coin:c) {
			for(int i=(int)coin;i<=n;i++) {
					dp[i] += dp[i-(int)coin];
			}
		}
		return dp[n];
	}
	public static void main(String args[]) {
		List<Long> arr = new ArrayList<Long>();
		arr.add((long) 2);
		arr.add((long) 5);
		arr.add((long) 3);
		arr.add((long) 6);
		int value = 10;
		Demo d = new Demo();
		
		System.out.println(d.getWay(value, arr));
	}
}
