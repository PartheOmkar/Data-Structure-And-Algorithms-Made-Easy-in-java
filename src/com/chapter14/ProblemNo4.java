package com.chapter14;
/*
Problem-4 Can we solve this problem in a single pass over given array?
Solution: We can use hash table to check whether a character is repeating in the given string or
	not. If the current character is not available in hash table, then insert it into hash table and keep
	that character in the given string also. If the current character exists in the hash table then skip that
	character.
 */
public class ProblemNo4 {
	public static void main(String[] args) {
		String str = "aaabbcertppqaaaaaaaaaaaaa";
		HashMapDS<Character,Boolean> temp = new HashMapDS<Character, Boolean>();
		String op = "";
		for(int i=0;i<str.length();i++) {
			if(temp.containKey(str.charAt(i))) {
				continue;
			}else {
				temp.put(str.charAt(i), true);
				op = op+str.charAt(i);
			}
		}
		System.out.println(op);
	}
	
}
