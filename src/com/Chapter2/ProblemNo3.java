package com.Chapter2;

public class ProblemNo3 {
	static int A[] = {1,2,3,4,5,6};
	
	private static void Solution(int n) {
		if(n<1) {
			System.out.println(A[n]);
			
		}else {
			A[n-1] = 0;
			Solution(n-1);
			A[n-1] = 1;
			Solution(n-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		Solution(n);
		
	}

}
