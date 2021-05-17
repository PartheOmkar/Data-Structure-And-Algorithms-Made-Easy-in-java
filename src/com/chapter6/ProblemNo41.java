package com.chapter6;
/*
 * Problem-41 :Given a tree, give an algorithm for finding the sum of all the elements of the tree.
   Solution: The solution is similar to what we have done for simple binary trees. That means,
	traverse the complete list and keep on adding the values. We can either use level order traversal
	or simple recursion.
 */
public class ProblemNo41 extends GenericTree{

	public void sumOfNodes() {
		System.out.println(sumOfNodes(root));
	}
	private int sumOfNodes(GenericTreeNode root) {
		int sum = 0;
		for(GenericTreeNode i:root.childerents) {
			sum += sumOfNodes(i);
		}
		return root.data+sum;
	}
	public static void main(String[] args) {
		
		ProblemNo41 p41 = new ProblemNo41();
		
		p41.insertdata(20, 0);
		p41.insertdata(5, 20);
		p41.insertdata(1, 20);
		p41.insertdata(6, 20);
		p41.insertdata(2, 1);
		p41.insertdata(11, 2);
		p41.insertdata(7, 2);
		p41.insertdata(8, 7);
		p41.insertdata(4, 6);
		
		p41.diaplayTree();
		
		p41.sumOfNodes();
	}
}
