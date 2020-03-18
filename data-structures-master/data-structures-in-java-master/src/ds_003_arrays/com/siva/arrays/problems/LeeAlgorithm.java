package com.siva.arrays.problems;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
	// (x, y) represents matrix cell coordinates
	// dist represent its minimum distance from the source
	//comment
	int x, y, dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
};

public class LeeAlgorithm {

	public static void main(String[] args) {
		int[][] mat =
			{
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			};

			// Find shortest path from source (0, 0) to
			// destination (7, 5)
			BFS(mat, 0, 0, 5, 9);

	}

	private static void BFS(int[][] mat, int i, int j, int k, int l) {
		Node source = new Node(i,j,0);
		Queue<Node> queue = new LinkedList<>();
		int rows = mat.length;
		int columns = mat[0].length;
		boolean[][] visited = new boolean[rows][columns];
		queue.offer(source);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			int x = curr.x;
			int y = curr.y;
			visited[x][y] = true;
			int dist = curr.dist;
			if(x == k && y == l) {
				System.out.println("destination found at distance "+curr.dist);
				return;
			}
			Node[] neighbours = {new Node(x,y-1,dist+1),new Node(x,y+1,dist+1),new Node(x-1,y,dist+1),new Node(x+1,y,dist+1)};
			for(Node neighbour : neighbours) {
				if(isValid(neighbour,rows,columns) && mat[neighbour.x][neighbour.y] == 1 && !visited[neighbour.x][neighbour.y]) {
					visited[neighbour.x][neighbour.y] = true;
					queue.offer(neighbour);
				}
			}
		}
		System.out.println("Destination is  not found");
	}


	private static boolean isValid(Node node, int rows, int columns) {
		if(node.x < 0 || node.y < 0 || node.x >= rows || node.y >= columns)
			return false;
		return true;
	}
}