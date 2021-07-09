package com.chapter18;

import java.util.ArrayList;
import java.util.Comparator;

public class ProblemNo24 {
	private static class Pair implements Comparable<Pair>{
		int x;
		int y;
		public Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair arg0) {
			return this.x-arg0.x;
		}
	}
	private static class Ysort implements Comparator<Pair>{
		@Override
		public int compare(Pair arg0, Pair arg1) {
			int y = arg0.y;
			int y2 = arg1.y;
			return y-y2;
		}
	}
	private static class Xsort implements Comparator<Pair>{
		@Override
		public int compare(Pair arg0, Pair arg1) {
			int x = arg0.x;
			int x2 = arg1.x;
			return x-x2;
		}
	}
	
	public double bruatforce(ArrayList<Pair> list) {
		int size = list.size()-1;
		double d = Double.MAX_VALUE;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				double min = minDistance(list.get(i),list.get(j));
				if(min<d) {
					d = min;
				}
			}
		}
		return d;
	}
	
	public double minDistance(Pair p1, Pair p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
	}
	
	public double stripPair(ArrayList<Pair> strip,double d) {
		int size = strip.size()-1;
		strip.sort(new Ysort());
		
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				double min = minDistance(strip.get(i),strip.get(j));
				if(min<d) {
					d = min;
				}
			}
		}
		return d;
	}
	
	public double shortestPair(ArrayList<Pair> points) {
		
		if(points.size()-1 <= 3) {
			return bruatforce(points);
		}
		
		ArrayList<Pair> left = new ArrayList<Pair>();
		ArrayList<Pair> right = new ArrayList<Pair>();
		int mid = points.size()/2;
		
		for(int i=0;i<mid;i++) {
			left.add(points.get(i));
		}
		for(int j=mid;j<points.size()-1;j++) {
			right.add(points.get(j));
		}
		
		double d1 = shortestPair(left);
		double d2 = shortestPair(right);
		double d = Math.min(d1, d2);
		
		ArrayList<Pair> strip = new ArrayList<Pair>();
//		for(int i=0;i<points.size()-1;i++) {
//			if(points.get(i).x-points.get(mid).x < d) {
//				strip.add(points.get(i));
//			}
//		}
		int leftIndex = mid-1;
		while(leftIndex>=0 && points.get(leftIndex).x-points.get(mid).x < d) {
			strip.add(points.get(leftIndex));
			leftIndex--;
		}
		int rightIndex = mid+1;
		while(rightIndex >= points.size()-1 && points.get(rightIndex).x-points.get(mid).x < d) {
			strip.add(points.get(rightIndex));
			rightIndex++;
		}
		
		double output = Math.min(d, stripPair(strip, d));
		
		return output;
	}
	
	public static void main(String[] args) {
		ArrayList<Pair> points = new ArrayList<Pair>();
		//{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}
		points.add(new Pair(2,3));
		points.add(new Pair(12,30));
		points.add(new Pair(40,50));
		points.add(new Pair(5,1));
		points.add(new Pair(12,10));
		points.add(new Pair(3,4));
		points.sort(new Xsort());
		
		ProblemNo24 p24 = new ProblemNo24();
		double output = p24.shortestPair(points);
		System.out.println(output);
	}
}
