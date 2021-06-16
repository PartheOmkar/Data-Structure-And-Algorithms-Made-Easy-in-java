package com.chapter14;
/*
Problem-14 Give an algorithm for finding the first non-repeated character in a string. For
	example, the first non-repeated character in the string “abzddab” is ‘z’.
Solution: The solution to this problem is trivial. For each character in the given string, we can
	scan the remaining string if that character appears in it. If it does not appears then we are done
	with the solution and we return that character. If the character appears in the remaining string, then
	go to the next character.
 */
public class ProblemNo13 {
	
	public static void main(String[] args) {
		String str = "abzddab";
		char output = 'a';
		boolean flag = false;
		for(int i=0;i<str.length()-1;i++) {
			for(int j=i+1;j<str.length();j++) {
				if(str.charAt(i)==str.charAt(j)) {
					flag = false;
					break;
				}else {
					flag = true;
				}
			}
			if(flag) {
				output = str.charAt(i);
				break;
			}
		}
		System.out.println(output);
	}
}
