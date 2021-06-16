package com.chapter14;
/*
Problem-2 Given an array of characters, give an algorithm for removing the duplicates.
Solution: Start with the first character and check whether it appears in the remaining part of the
	string using a simple linear search. If it repeats, bring the last character to that position and
	decrement the size of the string by one. Continue this process for each distinct character of the
	given string.
 */
public class ProblemNo2 {
	public static void main(String[] args) {
		String str = "aaabbcertppqaaaaaaaaaaaaa";
		String ans = "";
		for(int i=0;i<str.length();i++) {
			boolean flag = true;
			for(int j=0;j<ans.length();j++) {
				if(str.charAt(i)==ans.charAt(j)) {
					flag=false;
				}
			}
			if(flag) {
				ans = ans+str.charAt(i);
			}
		}
		System.out.println(ans);
	}
}
