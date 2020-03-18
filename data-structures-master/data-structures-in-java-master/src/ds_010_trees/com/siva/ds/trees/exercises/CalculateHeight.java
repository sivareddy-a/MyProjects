package com.siva.ds.trees.exercises;

import java.util.ArrayList;
import java.util.List;
//non-recursive java program for inorder traversal 
import java.util.Stack; 

/* Class containing left and right child of 
current node and key value*/


class CalculateHeight{
	public static void main(String args[]) 
	{ 

		BinaryTree tree1 = new BinaryTree(); 
		tree1.root = new Node(1); 
		tree1.root.left = new Node(2); 
		tree1.root.right = new Node(3); 
		tree1.root.left.left = new Node(4); 
		tree1.root.left.right = new Node(5); 
		System.out.println("Tree 1 ::: ");
		tree1.inorder(); 
		System.out.println();
		System.out.println("Rec - height of the binary tree is ::: "+heightRec(tree1.root));
		System.out.println("Itr - height of the binary tree is ::: "+heightItr(tree1.root));
		
	} 
	
	private static int heightItr(Node root) {
		if(root == null)
			return 0;
		int height = 0;
		Node top = null;
		Stack<Node> s = new Stack();
		s.push(root);
		while(!s.isEmpty()) {
			int size  = s.size();
			while(size-- > 0) {
				top = s.pop();
				if(top.left != null)
					s.push(top.left);
				if(top.right != null)
					s.push(top.right);
			}
			height ++;
		}		
		return height;
	}

	private static int heightRec(Node root) {
		if(root == null) return 0;
		return(Math.max(heightRec(root.left),heightRec(root.right)))+1;	
	}
}


