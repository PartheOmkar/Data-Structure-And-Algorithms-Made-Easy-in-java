package com.chapter17;
/*
 * this is a Fractional Knapsack algorithm
 */
import java.util.PriorityQueue;

public class Knapsack {
	public static class Sack implements Comparable<Sack>{
		int item;
		double weight;
		double benifit;
		public Sack(int item,double weight, double benifit) {
			this.item = item;
			this.weight = weight;
			this.benifit = benifit;
		}
		@Override
		public int compareTo(Sack arg0) {
			return (int) (arg0.benifit - this.benifit);
		}
	}
	public double knapsack(int[] items, double[] weight,double[] profit,double bagweight) {
		
		PriorityQueue<Sack> pq = new PriorityQueue<Knapsack.Sack>();
		for(int i=0;i<items.length;i++) {
			double benifits = profit[i]/weight[i];
			pq.add(new Sack(items[i],weight[i],benifits));
		}
	
		double p=0.0;
		while(bagweight>0) {
			Sack temp = pq.poll();
			System.out.println(temp.item+" "+temp.weight+" "+temp.benifit);
			if(bagweight>=temp.weight) {
				p = p+temp.benifit*temp.weight;
				bagweight = bagweight-temp.weight;
			}else {
				p = p+temp.benifit*bagweight;
				bagweight = 0;
			}
		}
		return p;
	}
	public static void main(String[] args) {
		int[] items = new int[] {1,2,3};
		double[] weight = new double[] {10.0,20.0,30.0};
		double[] profit = new double[] {60,100,120};
		double bagweight = 50.0;
		Knapsack kp = new Knapsack();
		System.out.println(kp.knapsack(items, weight,profit,bagweight));
	}
}
