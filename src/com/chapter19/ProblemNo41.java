package com.chapter19;
/*
Problem-41 Maximum sum sub-matrix: Given an n × n matrix M of positive and negative
	integers, give an algorithm to find the sub-matrix with the largest possible sum.
 */
import java.util.Arrays;

public class ProblemNo41 {
//	kadane's algo.
	public class Kadane{
		int sum = 0;
		int start = 0;
		int end = 0;
		public Kadane(int sum,int start,int end) {
			this.sum = sum;
			this.start = start;
			this.end = end;
		}
	}
	
	public class Matrixsum{
		int sum = 0;
		int topCol = 0;
		int topRow = 0;
		int bottomCol = 0;
		int bottomRow = 0;
		public Matrixsum(int sum,int topCol,int topRow,int bottomCol,int bottomRow) {
			this.sum = sum;
			this.topCol = topCol;
			this.topRow = topRow;
			this.bottomCol = bottomCol;
			this.bottomRow = bottomRow;
		}
	}
	
	public Kadane maxSubArray(int[] arr) {
		Kadane current = new Kadane(arr[0],0,0);
		Kadane best = new Kadane(0,0,0);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<=current.sum+arr[i]) {
				current.sum = current.sum+arr[i];
				current.end = i;
			}else {
				current.sum = arr[i];
				current.start= current.end = i;
			}
			if(best.sum<current.sum) {
				best.sum = current.sum;
				best.start = current.start;
				best.end = current.end;
			}
		}
		return best;
	}
	
	public Matrixsum matrixSum(int[][] matrix) {
		
		int[] dp = new int[matrix.length+1]; 
		Arrays.fill(dp, 0);
		Kadane arrsum = new Kadane(0, 0, 0);
		Matrixsum current = new Matrixsum(Integer.MIN_VALUE, 0, 0, 0, 0);

		for(int col=0;col<matrix[0].length;col++) {
			for(int next=col;next<matrix[0].length;next++) {
				for(int row=0;row<matrix.length;row++) {
					dp[row] += matrix[row][next];
				}
				arrsum = maxSubArray(dp);
				if(current.sum<arrsum.sum) {
					current.sum = arrsum.sum;
					current.topCol = col;
					current.topRow = arrsum.start;
					current.bottomCol = next;
					current.bottomRow = arrsum.end;
				}
			}
			Arrays.fill(dp, 0);
		}
		return current;
	}
	
	public static void main(String args[]) {
		
		int[][] arr = new int[][] { { 0, -2, -7, 0 },
            { 9, 2, -6, 2 },
            { -4, 1, -4, 1 },
            { -1, 8, 0, -2 } };
		ProblemNo41 p41 = new ProblemNo41();
		Matrixsum m = p41.matrixSum(arr);
		System.out.println(m.sum+" "+"["+m.topRow+" "+m.topCol+"] "+"["+m.bottomRow+" "+m.bottomCol+"]");
		for(int row=m.topRow;row<=m.bottomRow;row++) {
			for(int col=m.topCol;col<=m.bottomCol;col++) {
				System.out.printf("%-6s",arr[row][col]+" ");
			}
			System.out.println();
		}
	}
}
