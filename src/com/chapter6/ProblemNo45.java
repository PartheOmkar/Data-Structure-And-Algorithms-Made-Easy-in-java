package com.chapter6;
/*
 * Problem-45 : Given a node in the generic tree, find the number of siblings for that node.
Solution: For a given node in the tree, we just need to traverse all its next siblings.
 */

public class ProblemNo45 extends GenericTree{

	public void findSebelingOfNode(int data) {
		
		GenericTreeNode ans =  searchNode(root, data);
		int count=0;
		System.out.println("siblings of The Node = "+data);
		for(GenericTreeNode i : ans.childerents) {
			if(i.data==data) {
				continue;
			}
			System.out.print(i.data+" ");
			count++;
		}
		System.out.println("count = "+count);
	}
//	this function return the parent of a node
	private GenericTreeNode searchNode(GenericTreeNode root,int data) {
		GenericTreeNode ans=null;
		for(GenericTreeNode i:root.childerents) {
			if(i.data==data) {
				return root;
			}
		}
		for(GenericTreeNode i:root.childerents) {
			ans = searchNode(i, data);
			if(ans!=null) {
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		ProblemNo45 p45 = new ProblemNo45();
		p45.insertdata(0, -1);
		p45.insertdata(5, 0);
		p45.insertdata(1, 0);
		p45.insertdata(6, 0);
		p45.insertdata(2, 1);
		p45.insertdata(7, 2);
		p45.insertdata(8, 7);
		p45.insertdata(4, 6);
		
		p45.diaplayTree();
		
		p45.findSebelingOfNode(5);
	}
}
