package com.siva.ds.trees.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;


public class TreeTraversals {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(6);
		tree.root.right.left.left = new Node(7); 
		tree.root.right.left.right = new Node(8); 
		System.out.println("Tree pre - order  ::: ");
		preorderItr(tree.root);
		System.out.println();
		System.out.println("Tree in - order  ::: ");
		inorderItr(tree.root);
		System.out.println();
		System.out.println("Tree post - order  ::: ");
		postorderItr(tree.root);
		System.out.println();
		System.out.println("Tree level - order  ::: ");
		levelorder(tree.root);
		System.out.println();
		System.out.println("Tree reverse level - order  ::: ");
		levelorderRev(tree.root);
		System.out.println();
		System.out.println("Tree left view - recursion  ::: ");
		Map<Integer,Node> leftViewMap = new HashMap();
		leftViewRec(1,tree.root,leftViewMap);
		for(int i=1; i<=leftViewMap.size(); i++)
			System.out.print(leftViewMap.get(i).data+"  ");
		System.out.println();
		System.out.println("Tree left view - iterative  ::: ");
		leftViewItr(tree.root);
		System.out.println();
		System.out.println("Tree right view - recursion  ::: ");
		Map<Integer,Node> rightViewMap = new HashMap();
		rightViewRec(1,tree.root,rightViewMap);
		for(int i=1; i<=rightViewMap.size(); i++)
			System.out.print(rightViewMap.get(i).data+"  ");
		System.out.println();
		System.out.println("Tree right view - iterative  ::: ");
		rightViewItr(tree.root);
		System.out.println();
		System.out.println("Tree top view - recursion  ::: ");
		Map<Integer,Pair<Integer,Integer>> topViewMap = new TreeMap();
		topViewRec(tree.root,0,0,topViewMap);
		for(Integer key : topViewMap.keySet())
			System.out.print(topViewMap.get(key).first+"  ");
		System.out.println();
		System.out.println("Tree bottom view - recursion  ::: ");
		Map<Integer,Pair<Integer,Integer>> bottomViewMap = new TreeMap();
		bottomViewRec(tree.root,0,0,bottomViewMap);
		for(Integer key : bottomViewMap.keySet())
			System.out.print(bottomViewMap.get(key).first+"  ");  		
	}
	
	private static void bottomViewRec(Node root, int dist, int level, Map<Integer, Pair<Integer, Integer>> bottomViewMap) {
		if(root == null)
			return;
		if(!bottomViewMap.containsKey(dist) || level >= bottomViewMap.get(dist).second)
			bottomViewMap.put(dist,Pair.of(root.data, level));
		bottomViewRec(root.left, dist-1, level+1, bottomViewMap);
		bottomViewRec(root.right, dist+1, level+1, bottomViewMap);		
	}
	
	private static void topViewRec(Node root, int dist, int level, Map<Integer, Pair<Integer, Integer>> topViewMap) {
		if(root == null)
			return;
		if(!topViewMap.containsKey(dist) || level < topViewMap.get(dist).second)
			topViewMap.put(dist,Pair.of(root.data, level));
		topViewRec(root.left, dist-1, level+1, topViewMap);
		topViewRec(root.right, dist+1, level+1, topViewMap);		
	}

	private static void rightViewItr(Node root) {
		if(root == null)
			return;
		Queue<Node> q  = new LinkedList();
		q.offer(root);
		Node curr;
		while(!q.isEmpty()) {
			int size  =q.size();
			int i = 0;
			while(i++ < size) {
				curr = q.poll();
				if(i == 1)
					System.out.print(curr.data+"  ");
				if(curr.right != null) 
					q.offer(curr.right);
				if(curr.left!= null) 
					q.offer(curr.left);								
			}
		}		
	}

	private static void rightViewRec(int level, Node root, Map<Integer, Node> rightViewMap) {
		if(root == null)
			return;
		if(!rightViewMap.containsKey(level))
			rightViewMap.put(level, root);	
		rightViewRec(level+1,root.right,rightViewMap);
		rightViewRec(level+1,root.left,rightViewMap);
	}

	private static void leftViewItr(Node root) {
		if(root == null)
			return;
		Queue<Node> q  = new LinkedList();
		q.offer(root);
		Node curr;
		while(!q.isEmpty()) {
			int size  =q.size();
			int i = 0;
			while(i++ < size) {
				curr = q.poll();
				if(i == 1)
					System.out.print(curr.data+"  ");
				if(curr.left!= null) 
					q.offer(curr.left);
				if(curr.right != null) 
					q.offer(curr.right);				
			}
		}		
	}

	private static void leftViewRec(int level, Node root, Map<Integer, Node> leftViewMap) {
		if(root == null)
			return;
		if(!leftViewMap.containsKey(level))
			leftViewMap.put(level, root);
		leftViewRec(level+1,root.left,leftViewMap);	
		leftViewRec(level+1,root.right,leftViewMap);
	}

	private static void levelorderRev(Node root) {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList();
		Stack<Node> s = new Stack();
		q.offer(root);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			s.push(curr);
			if(curr.right != null)
				q.offer(curr.right);	
			if(curr.left != null)
				q.offer(curr.left);					
		}	
		while(!s.isEmpty()) 			
			System.out.print(s.pop().data+"  ");
	}

	
	private static void levelorder(Node root) {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		while(!q.isEmpty()) {
			Node curr = q.peek();
			if(curr.left != null)
				q.offer(curr.left);
			if(curr.right != null)
				q.offer(curr.right);
			curr = q.poll();
			System.out.print(curr.data+"  ");
		}		
	}

	private static void postorderItr(Node root) {
		if (root == null) 
			return;
		
		Stack<Node> s = new Stack<Node>(); 
		Node curr = root; 
		Node temp = null;
					while (curr != null || s.size() > 0) 
					{ 

					if(curr != null) {
						s.push(curr);
						curr = curr.left;
					}else {
						temp = s.peek().right;
						if(temp == null) {
							temp = s.pop();
							System.out.print(temp.data + "  "); 
							while(!s.isEmpty() && temp == s.peek().right) {
								temp = s.pop();
								System.out.print(temp.data + "  "); 
							}
						}else {
							curr = temp;
						}
					}
					}
	}

	private static void inorderItr(Node root) {
		if(root == null)
			return;
		Stack<Node> s = new Stack();
			
		Node curr  = root;
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.data+"  ");		
			curr=curr.right;			
		}		
	}

	private static void preorderItr(Node root) {
		if(root == null)
			return;
		Stack<Node> s = new Stack();
		s.push(root);		
		/*
		 * while(!s.isEmpty()) { Node curr = s.pop(); System.out.print(curr.data + " ");
		 * if(curr.right != null) s.push(curr.right); if(curr.left != null)
		 * s.push(curr.left); }
		 */
		Node curr  = root;
		while(!s.isEmpty()) {
			if(curr != null) {
				System.out.print(curr.data+"  ");
				if(curr.right != null)
					s.push(curr.right);
				curr = curr.left;
			}
			else {
				curr = s.pop();
			}
		}
	}

}
