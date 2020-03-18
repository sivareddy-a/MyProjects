package com.siva.ds.trees.exercises;

import java.util.ArrayList;
import java.util.List;
//non-recursive java program for inorder traversal 
import java.util.Stack; 

class Pair<U, V>
{
	public final U first;   	// first field of a Pair
	public final V second;  	// second field of a Pair

	// Constructs a new Pair with specified values
	private Pair(U first, V second)
	{
		this.first = first;
		this.second = second;
	}

	// Factory method for creating a Typed Pair immutable instance
	public static <U, V> Pair <U, V> of(U a, V b)
	{
		// calls private constructor
		return new Pair<>(a, b);
	}
}

class CompareTrees{
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
		BinaryTree tree2 = new BinaryTree(); 
		tree2.root = new Node(1); 
		tree2.root.left = new Node(2); 
		tree2.root.right = new Node(3); 
		tree2.root.left.left = new Node(4); 
		tree2.root.left.right = new Node(5); 
		System.out.println("Tree 2 ::: ");
		tree2.inorder(); 
		System.out.println();
		System.out.println("Rec - are tree1 and 2 identical ? ::: "+compareTreesRec(tree1.root, tree2.root));
		System.out.println("Itr - are tree1 and 2 identical ? ::: "+compareTreesItr(tree1.root, tree2.root));
		
	} 
	private static boolean compareTreesItr(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root2 == null)
			return false;
		Stack<Pair> s = new Stack();
		s.push(Pair.of(root1,  root2));
		while(!s.isEmpty()) {
			Pair<Node,Node> pair = s.pop();
			Node x = pair.first;
			Node y = pair.second;
			if(x.data != y.data) return false;
			if(x.left != null && y.left != null) 
				s.push(Pair.of(x.left, y.left));
			else if(x.left != null || y.left != null)
				return false;
			if(x.right != null && y.right != null) 
				s.push(Pair.of(x.right, y.right));
			else if(x.right != null || y.right != null)
				return false;			
		}
		return true;
	}
	private static boolean compareTreesRec(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		return ((root1 != null && root2 != null) && (root1.data == root2.data) &&
				compareTreesRec(root1.left,root2.left) && compareTreesRec(root1.right,root2.right));
	}

}

