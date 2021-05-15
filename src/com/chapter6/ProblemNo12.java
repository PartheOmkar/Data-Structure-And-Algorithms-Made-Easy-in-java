package com.chapter6;
/*
 * Problem-12 :- Can we solve Problem-10 without recursion?
Solution: Yes. Using level order traversal. This is similar to BFS of Graph algorithms. End of
level is identified with NULL.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo12 extends BinaryTree{

	public void getHeightOfTree() {
		System.out.println(getHeightOfTree(root));
	}
	private int getHeightOfTree(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
		level.add(root);
		level.add(null);
		int maxcout = 0;
		BinaryTreeNode previous = null;
		while(!level.isEmpty()) {
		
			BinaryTreeNode temp = level.remove();
			if(previous==null && temp==null) {
				break;
			}
			if(temp==null) {
				maxcout++;
				level.add(null);
				previous = temp;
				continue;
			}
			if(temp.left!=null) {
				level.add(temp.left);
			}
			if(temp.right!=null) {
				level.add(temp.right);
			}
			previous = temp;
		}
//		System.out.println("Height Of Tree is = "+maxcout);
		return maxcout;
	}
	public static void main(String[] args) {
		ProblemNo12 p12 = new ProblemNo12();
		
		p12.nodeInsert(5);
		p12.nodeInsert(2);
		p12.nodeInsert(7);
		p12.nodeInsert(1);
		p12.nodeInsert(6);
		p12.nodeInsert(9);
		p12.nodeInsert(3);
		p12.nodeInsert(4);
		p12.binaryTreeDisplay();
		
		p12.getHeightOfTree();
	}
}
