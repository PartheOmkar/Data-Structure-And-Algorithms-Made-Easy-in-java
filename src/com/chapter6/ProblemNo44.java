package com.chapter6;
/*
 * Problem-44 Given a parent array P, where P[i] indicates the parent of i th node in the tree
	(assume parent of root node is indicated with –1). Give an algorithm for finding the heightor depth of the tree.
Solution: From the problem definition, the given array represents the parent array. That means,
	we need to consider the tree for that array and find the depth of the tree.
 */
public class ProblemNo44 extends GenericTree{

	public void heightOfTree() {
		int height = heightOfTree(root)-1;
		System.out.println("height Of Tree is = "+height);
	}
	private int heightOfTree(GenericTreeNode root) {
		int height = 0;
		for(GenericTreeNode i:root.childerents) {
			height = Math.max(height,heightOfTree(i));
		}
		return height+1;
	}
	public static void main(String[] args) {
		ProblemNo44 p44 = new ProblemNo44();
		
		p44.insertdata(0, -1);
		p44.insertdata(5, 0);
		p44.insertdata(1, 0);
		p44.insertdata(6, 0);
		p44.insertdata(2, 1);
		p44.insertdata(7, 2);
		p44.insertdata(8, 7);
		p44.insertdata(4, 6);
		
		p44.diaplayTree();
		
		p44.heightOfTree();
	}
}
