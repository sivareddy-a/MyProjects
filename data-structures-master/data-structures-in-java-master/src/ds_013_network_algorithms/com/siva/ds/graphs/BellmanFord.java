package com.siva.ds.graphs;

import java.util.Arrays;
import java.util.List;

class BellmanFord
{
	// Recursive Function to print path of given vertex v from source vertex
	static void printPath(int parent[], int v)
	{
		if (v < 0)
			return;

		printPath(parent, parent[v]);
		System.out.print(v + " ");
	}

	// Function to run Bellman Ford Algorithm from given source
	public static void BellmanFord(List<WEdge> edges, int source, int N) {

		// get number of edges present in the graph
		int E = edges.size();

		// distance[] and parent[] stores shortest-path
		// (least cost/path) information
		int distance[] = new int[N];
		int parent[] = new int[N];

		// initialize distance[] and parent[]. Initially all
		// vertices except source vertex have a weight of
		// infinity and a no parent
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		
		Arrays.fill(parent, -1);

		int k = N;

		// Relaxation step (run V -1 times)
		while (--k > 0)
		{
			for (int j = 0; j < E; j++)
			{
				// edge from u to v having weight w
				int u = edges.get(j).src;
				int v = edges.get(j).dest;
				int w = edges.get(j).weight;

				// if the distance to the destination v can be
				// shortened by taking the edge u-> v
				if (distance[u] != Integer.MAX_VALUE &&
					(distance[u] + w < distance[v]))
				{
					// update distance to the new lower value
					distance[v] = distance[u] + w;

					// set v's parent as u
					parent[v] = u;
				}
			}
		}

		// run relaxation step once more for Nth time to
		// check for negative-weight cycles
		for (int i = 0; i < E; i++)
		{
			// edge from u to v having weight w
			int u = edges.get(i).src;
			int v = edges.get(i).dest;
			int w = edges.get(i).weight;

			// if the distance to the destination u can be
			// shortened by taking the edge u-> v
			if (distance[u] != Integer.MAX_VALUE &&
				(distance[u] + w < distance[v]))
			{
				System.out.println("Negative Weight Cycle Found!!");
				return;
			}
		}

		for (int i = 0; i < N; i++)
		{
			System.out.print("Distance of vertex " + i + " from the " +
					"source is " + distance[i] + ". It's path is [ ");

			printPath(parent, i);
			System.out.println("]");
		}
	}

	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<WEdge> edges = Arrays.asList(
				// (x, y, w) -> edge from x to y having weight w
				new WEdge( 0, 1, -1 ), new WEdge( 0, 2, 4 ),
				new WEdge( 1, 2, 3 ), new WEdge( 1, 3, 2 ),
				new WEdge( 1, 4, 2 ), new WEdge( 3, 2, 5 ),
				new WEdge( 3, 1, 1 ), new WEdge( 4, 3, -3 )
		);

		// Number of vertices in the graph
		final int N = 5;

		// let source be vertex 0
		int source = 0;

		// run Bellman Ford Algorithm from given source
		BellmanFord(edges, source, N);
	}
}
