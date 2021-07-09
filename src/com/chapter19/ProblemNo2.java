package com.chapter19;

import java.util.Arrays;

public class ProblemNo2 {
	int[] arr;
	int count;
	public void funOp(int n) {
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		arr[0] = arr[1] = 2;
		System.out.println(fun(n));
		System.out.println(count);
	}
	private int fun(int n) {
		int sum = 0;
		if(arr[n]!=-1) {
			return arr[n];
		}
		for(int i=1;i<n;i++) {
			sum += 2*fun(i)*fun(i-1);
		}
		arr[n] = sum;
		count++;
		return sum;
	}
	public static void main(String[] args) {
		ProblemNo2 p2 = new ProblemNo2();
		p2.funOp(5);
	}
}
