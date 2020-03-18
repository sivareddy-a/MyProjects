package ds_010_trees;

import java.util.ArrayList;
import java.util.List;
//non-recursive java program for inorder traversal 
import java.util.Stack; 

/* Class containing left and right child of 
current node and key value*/
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


class InorderWithoutRecursion{
	public static void main(String args[]) 
	{ 

		/* creating a binary tree and entering 
		the nodes */
		InorderWithoutRecursion test = new InorderWithoutRecursion();
		BinaryTree tree = test.new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.inorder(); 
		System.out.println();
		tree.preorder();
		System.out.println();
		tree.postorder();
	} 
	/* Class to print the inorder traversal */
	class BinaryTree 
	{ 
		Node root; 
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
		void preorder() 
		{ 
			if (root == null) 
				return;
			
			Stack<Node> s = new Stack<Node>(); 
			Node curr = root; 
			s.push(root);

			while (s.size() > 0) 
			{ 
				curr = s.pop(); 
				System.out.print(curr.data + " "); 
				if(curr.right != null) {
					s.push(curr.right);
				}		
				if(curr.left != null) {
					s.push(curr.left); 
				} 						
			} 
		} 		
		void postorder() 
		{ 
			if (root == null) 
				return;
			
			Stack<Node> s = new Stack<Node>(); 
			List<Node> result = new ArrayList<Node>();
			Node curr = root; 
			s.push(curr);
			// traverse the tree 
						while (s.size() > 0) 
						{ 

							/* Reach the left most Node of the 
							curr Node */
							while (!(result.contains(curr)) && (curr.left != null || curr.right != null)) 
							{ 
								if(curr.right != null) {
									s.push(curr.right);
									// curr=curr.right;
								}		
								if(curr.left != null) {
									s.push(curr.left); 
									// curr = curr.left;
								} 	
								curr = s.peek();
							} 

							/* Current must be NULL at this point */
							curr = s.pop(); 
							result.add(curr);

							System.out.print(curr.data + " "); 

							/* we have visited the node and its 
							left subtree. Now, it's right 
							subtree's turn */
							curr = s.peek(); 
						} 
		} 		
	} 
}
