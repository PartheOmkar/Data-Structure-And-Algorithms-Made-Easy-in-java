package com.chapter19;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemNo23 {
	// blue print / structure of box
	private class Box{
		int height;
		int width;
		int depth;
		public Box(int height,int width,int depth) {
			this.height = height;
			this.width = width;
			this.depth = depth;
		}
	}
	
	private static class BoxSort implements Comparator<Box>{
		@Override
		public int compare(Box arg0,Box arg1) {
			// sort by descending order
			return (arg1.width*arg1.depth)-(arg0.width*arg0.depth);
		}
	}
	
	public void box(int[] height,int[] width,int[] depth) {
		int index = 0;
		Box[] boxes = new Box[height.length*3];
		// create permutations of boxes, so we dont care about rotation
		for(int i=0;i<height.length;i++) {
			// permutation 1
			int h1 = height[i];
			// assign maximum value to the width
			int w1 = Math.max(width[i], depth[i]);
			// assign minimum value to the depth
			int d1 = Math.min(width[i], depth[i]);
			boxes[index] = new Box(h1, w1, d1);
			index ++;
			// permutation 2
			int h2 = width[i];
			int w2 = Math.max(height[i], depth[i]);
			int d2 = Math.min(height[i], depth[i]);
			boxes[index] = new Box(h2,w2,d2);
			index ++;
			// permutation 3
			int h3 = depth[i];
			int w3 = Math.max(height[i], width[i]);
			int d3 = Math.min(height[i], width[i]);
			boxes[index] = new Box(h3,w3,d3);
			index ++;
		}
		// sort array by descending order (order is accoerding to w*d)
		Arrays.sort(boxes, new BoxSort());
//		for(Box b:boxes) {
//			System.out.println(b.height+" "+b.width+" "+b.depth);
//		}
		boxOnStack(boxes);
	}
	
	public void boxOnStack(Box[] boxes) {
		int[] dp = new int[boxes.length+1];
		// assign the default value for dp array
		for(int i=0;i<boxes.length;i++) {
			dp[i] = boxes[i].height;
		}
		for(int i=0;i<boxes.length;i++) {
			for(int j=0;j<i;j++) {
				if(boxes[i].width < boxes[j].width && boxes[i].depth < boxes[j].depth) {
					dp[i] = Math.max(dp[i],dp[j]+boxes[i].height);
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
		int[] height = new int[] {10,4,4};
		int[] width = new int[] {12,6,5};
		int[] depth = new int[] {32,7,6};
		
		ProblemNo23 p23 = new ProblemNo23();
		p23.box(height, width, depth);
	}
}
