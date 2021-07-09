package com.chapter19;

import java.util.Arrays;

public class FibonacciSeries {
	
//	Time complexity O(2^n) and space complexity O(n)
	public int fib(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		int ans = fib(n-1)+fib(n-2);
		return ans;
	}
//	Time complexity O(n) and space complexity O(n)
	int[] arr = new int[20];
	public int fib2(int n) {
		Arrays.fill(arr,-1);
		arr[0]=arr[1]=1;
		fib2temp(n);
		return arr[n];
	}
	public int fib2temp(int n) {
		if(arr[n]!=-1) {
			return arr[n];
		}
		arr[n] = fib2temp(n-1)+fib2temp(n-2);
		return arr[n];
	}
//	time complexity is O(n) and space complexity O(3)
	public int fib3(int n) {
		int current_previous = 1;
		int previous_previous = 1;
		int current = 0;
		for(int i=2;i<=n;i++) {
			current = current_previous + previous_previous;
			previous_previous = current_previous;
			current_previous = current;
		}
		return current;
	}
	public static void main(String[] args) {
		FibonacciSeries fb = new FibonacciSeries();
		System.out.println(fb.fib(5));
		System.out.println(fb.fib2(5));
		System.out.println(fb.fib3(5));
	}
}
