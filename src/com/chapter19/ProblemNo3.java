package com.chapter19;

import java.util.Arrays;

public class ProblemNo3 {
	
	int[] arr;
	int count = 0;
	public void funOp(int n) {
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		arr[0] = 2;
		arr[1] = 2;
		arr[2] = 2*arr[1]*arr[0];
		System.out.println(fun(n));
		System.out.println(count);
	}
	private int fun(int n) {

		for(int i=3;i<=n;i++){
			arr[i] = arr[i-1] + 2*arr[i-1]*arr[i-2];
		}
		count++;
		return arr[n];
	}
	public static void main(String[] args) {
		ProblemNo3 p3 = new ProblemNo3();
		p3.funOp(5);
	}
}
