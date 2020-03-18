package com.siva.ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.siva.ds.graphs.GraphList.Edge;

class DGraph
{
	// A List of Lists to raepresent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	DGraph(List<Edge> edges, int N)
	{
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (int i = 0; i < edges.size(); i++)
		{
			int src = edges.get(i).src;
			int dest = edges.get(i).dest;

			adjList.get(src).add(dest);
		}
	}
}
public class DirectedGraphProblems {

	public static void main(String[] args)
	{
		List<Edge> edges = Arrays.asList(
							new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
							new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
							new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
						);

		final int N = 8;
		DGraph graph = new DGraph(edges, N);
		System.out.println("Computing topological order :::: ");
		Stack<Integer> topOrder = new Stack();
		boolean[] visited = new boolean[N];
		for(int v=0; v<N; v++) {
			if(!visited[v])
				topologicalSortRec(graph, v,visited,topOrder);
		}
		while(!topOrder.isEmpty())
			System.out.print(topOrder.pop()+"  ");
			
	}

	private static void topologicalSortRec(DGraph graph, int v, boolean[] visited, Stack<Integer> topOrder) {
		if(!visited[v])
			visited[v] = true;
		for(int u: graph.adjList.get(v))
			if(!visited[u])
				topologicalSortRec(graph,u,visited,topOrder);
		topOrder.push(v);		
	}

}
