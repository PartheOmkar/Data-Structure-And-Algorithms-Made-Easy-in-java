package com.chapter6;
/*
 * Problem-8 Give an algorithm for deleting the tree.
Solution: To delete a tree, we must traverse all the nodes of the tree and delete them one by one.
So which traversal should we use: Inorder, Preorder, Postorder or Level order Traversal?
Before deleting the parent node we should delete its children nodes first. We can use postorder
traversal as it does the work without storing anything. We can delete tree with other traversals
also with extra space complexity. For the following, tree nodes are deleted in order - 4,5,2,3,1.
 */
public class ProblemNo8 extends BinaryTree{
	
	public void deleteTree() {
		//in java it will take care by garbage collector 
		root = null;
		System.out.println("Tree Deleted sucessfully");
	}
	// try in traversal order
	public void deleteTreeInPostorder() {
		deleteTreeInPostorder(root);
		System.out.println("Tree Deleted sucessfully");
	}
	private void deleteTreeInPostorder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		deleteTreeInPostorder(root.left);
		deleteTreeInPostorder(root.right);
		root=null;
	}
	public static void main(String[] args) {
		
		ProblemNo8 p8 = new ProblemNo8();
		p8.nodeInsert(5);
		p8.nodeInsert(7);
		p8.nodeInsert(3);
		p8.nodeInsert(6);
		p8.nodeInsert(1);
		p8.nodeInsert(9);
		p8.binaryTreeDisplay();
		
		p8.deleteTreeInPostorder();
	}
}
