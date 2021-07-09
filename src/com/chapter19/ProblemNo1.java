package com.chapter19;
/*
Problem-1 Convert the following recurrence to code.
 */
public class ProblemNo1 {
	int count=0;
	public int f(int n) {
		int sum = 0;
		if(n==0 || n==1) {
			return 2;
		}
		for(int i=1;i<n;i++) {
			sum += 2*f(i)*f(i-1);
		}
		count++;
		return sum;
	}
	public static void main(String[] args) {
		ProblemNo1 p1 = new ProblemNo1();
		System.out.println(p1.f(5));
		System.out.println(p1.count);
	}
}
