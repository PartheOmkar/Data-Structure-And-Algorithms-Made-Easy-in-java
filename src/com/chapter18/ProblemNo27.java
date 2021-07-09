package com.chapter18;

public class ProblemNo27 {
	
	public int findMax(int[] arr,int min,int max) {
		
		int lMax = Integer.MIN_VALUE;
		int rMax = Integer.MIN_VALUE;
		int sum = 0;
		if(min==max) {
			return arr[min];
		}
		
		int mid = min+(max-min)/2;
		
		int leftMax = findMax(arr, min, mid);
		int rightMax = findMax(arr,mid+1,max);

		for(int i=mid;i>=min;i--) {
			sum += arr[i];
			lMax = (sum>lMax)?sum:lMax;
		}
		sum = 0;
		for(int j=mid+1;j<=max;j++) {
			sum += arr[j];
			rMax = (sum>rMax)?sum:rMax;
		}
		
		int result = Math.max(rightMax, leftMax);
		
		return Math.max(result,lMax+rMax);
	}
	public static void main(String[] args) {
		int[] arr = new int[] {-2, 11, -4, 13 , -5, 2};
		ProblemNo27 p27 = new ProblemNo27();
		System.out.println(p27.findMax(arr, 0, arr.length-1));
	}
}
