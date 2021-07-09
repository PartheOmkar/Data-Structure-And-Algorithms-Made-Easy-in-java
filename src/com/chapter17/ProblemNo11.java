package com.chapter17;

import java.util.ArrayList;

/*
Problem-11 Consider the making change problem in the country of India. The input to this
	problem is an integer M. The output should be the minimum number of coins to make M
	rupees of change. In India, assume the available coins are 1,5,10,20,25,50 rupees. Assume
	that we have an unlimited number of coins of each type.
	For this problem, does the following algorithm produce the optimal solution or not?
	Take as many coins as possible from the highest denominations. So for example, to make
	change for 234 rupees the greedy algorithm would take four 50 rupee coins, one 25 rupee
	coin, one 5 rupee coin, and four 1 rupee coins.
Solution: The greedy algorithm is not optimal for the problem of making change with the
	minimum number of coins when the denominations are 1,5,10,20,25, and 50. In order to make 40
	rupees, the greedy algorithm would use three coins of 25,10, and 5 rupees. The optimal solution
	is to use two 20-shilling coins.
 */
public class ProblemNo11 {
	public void coinChange(int m) {
		int[] coins = new int[] {50,25,20,10,5,1};
		ArrayList<Integer> output = new ArrayList<Integer>();
		while(m!=0) {
			for(int i:coins) {
				while(m>=i) {
					output.add(i);
					m = m-i;
				}
			}
		}
		System.out.println(output);
	}
	public static void main(String[] args) {
		int m = 234;
		ProblemNo11 p11 = new ProblemNo11();
		p11.coinChange(m);
		m = 40;
		p11.coinChange(m);
	}
}
