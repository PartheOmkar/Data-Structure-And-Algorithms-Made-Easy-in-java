package com.chapter17;

import java.util.PriorityQueue;

public class ProblemNo15 {
	 static class Train implements Comparable<Train>{
		 int time;
		 boolean comeTostation;
		public Train(int time,boolean comeTostation) {
			this.time = time;
			this.comeTostation = comeTostation;
		}
		public int compareTo(Train arg0) {
			return this.time - arg0.time;
		}
	}
	 
	public void train(int[] arrival, int[] departure) {
		PriorityQueue<Train> pq = new PriorityQueue<ProblemNo15.Train>();
		for(int i : arrival) {
			pq.add(new Train(i,true));
		}
		for(int j:departure) {
			pq.add(new Train(j, false));
		}
		int i = arrival.length;
		int station=0;
		int max = 0;
		while(i>0) {
			Train temp = pq.poll();
			if(temp.comeTostation) {
				station = station+1;
				max = max<station?station:max;
				i--;
			}else {
				station = station-1;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		int[] arrival = new int[] {900, 940, 950, 1100, 1500, 1800};
		int[] departure = new int[] {910, 1200, 1120, 1130, 1900, 2000};
		ProblemNo15 p15 = new ProblemNo15();
		p15.train(arrival, departure);
	}
}
