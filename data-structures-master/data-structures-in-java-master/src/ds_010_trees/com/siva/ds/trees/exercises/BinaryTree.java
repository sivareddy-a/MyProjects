package com.siva.ds.trees.exercises;

import java.util.Stack;

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 
class BinaryTree 
{ 
	Node root; 
	boolean hasLeft(Node x) {
		return x.left != null;
	}
	boolean hasRight(Node x) {
		return x.right != null;
	}
	boolean isLeft(Node a, Node b) {
		return a.left == b;
	}
	boolean isRight(Node a, Node b) {
		return a.right == b;
	}
	void inorder() 
	{ 
		if (root == null) 
			return; 


		Stack<Node> s = new Stack<Node>(); 
		Node curr = root; 

		// traverse the tree 
		while (curr != null || s.size() > 0) 
		{ 

			/* Reach the left most Node of the 
			curr Node */
			while (curr != null) 
			{ 
				/* place pointer to a tree node on 
				the stack before traversing 
				the node's left subtree */
				s.push(curr); 
				curr = curr.left; 
			} 

			/* Current must be NULL at this point */
			curr = s.pop(); 

			System.out.print(curr.data + " "); 

			/* we have visited the node and its 
			left subtree. Now, it's right 
			subtree's turn */
			curr = curr.right; 
		} 
	} 		
} 
