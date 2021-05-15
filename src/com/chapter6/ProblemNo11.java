package com.chapter6;
/*
 * Problem-11 :- Can we solve Problem-10 with stack?
Solution: We can use stack to simulate recursion.
 */
import java.util.Stack;

public class ProblemNo11 extends BinaryTree{

	public void getHeightOfTree() {
		getHeightOfTree(root);
	}
	private void getHeightOfTree(BinaryTreeNode root) {
		
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		BinaryTreeNode previous = null;
		BinaryTreeNode current;
		st.push(root);
		int maxSize = 0;
		while(!st.isEmpty()) {
			current = st.peek();
			if(previous==null || previous.left == current || previous.right == current) {
				if(current.left!=null) {
					st.push(current.left);
				}
				else if(current.right!=null) {
					st.push(current.right);
				}
			}else if(current.left==previous) {
				if(current.right!=null) {
					st.push(current.right);
				}
			}else {
				st.pop();
			}
			previous = current;
			if(st.size()>maxSize) {
				maxSize = st.size();
			}
		}
		System.out.println("Height Of Tree is = "+maxSize);
	}
	public static void main(String[] args) {
		
		ProblemNo11 p11 = new ProblemNo11();
		p11.nodeInsert(5);
		p11.nodeInsert(7);
		p11.nodeInsert(3);
		p11.nodeInsert(6);
		p11.nodeInsert(1);
		p11.nodeInsert(9);
		p11.nodeInsert(10);
		p11.binaryTreeDisplay();
		
		p11.getHeightOfTree();
	}
}
