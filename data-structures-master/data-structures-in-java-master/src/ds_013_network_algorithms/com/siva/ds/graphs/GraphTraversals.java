package com.siva.ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.siva.ds.graphs.GraphList.Edge;

class Graph
{
	// A List of Lists to raepresent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N)
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
			adjList.get(dest).add(src);
		}
	}
}

class ArrivalDeparture{
	int aTime;
	int dTime;
	ArrivalDeparture(){
		aTime = 0;
		dTime = 0;
	}
}

public class GraphTraversals {

	public static void main(String[] args) {
				List<Edge> edges = Arrays.asList(
						new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
						new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
						new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
						new Edge(7, 11), new Edge(7, 12)
						// vertex 0, 13 and 14 are single nodes
				);

				// Set number of vertices in the graph
				final int N = 15;

				// create a graph from edges
				Graph graph = new Graph(edges,N);
				
				// stores vertex is discovered or not
				boolean[] discovered = new boolean[N];

				System.out.println("BFS iterative");
				// Do BFS traversal from all undiscovered nodes to
				// cover all unconnected components of graph
				for (int i = 0; i < N; i++) {
					if (discovered[i] == false) {
						// start BFS traversal from vertex i
						BFSItr(graph, i, discovered);
					}
				}
				System.out.println();
				System.out.println("BFS recursive");
				discovered = new boolean[N];
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < N; i++) {
					if (discovered[i] == false) {
						q.add(i);
						BFSRec(graph, q, discovered);
					}
				}
				discovered = new boolean[N];
				System.out.println();
				System.out.println("DFS iterative");
				for (int i = 0; i < N; i++) {
					if (discovered[i] == false) {
						DFSItr(graph, i, discovered);
					}
				}
				discovered = new boolean[N];
				System.out.println();
				System.out.println("DFS recursive");
				for (int i = 0; i < N; i++) {
					if (discovered[i] == false) {
						DFSRec(graph, i, discovered);
					}
				}
				discovered = new boolean[N];
				System.out.println();
				System.out.println("Arriavl Departure");
				ArrivalDeparture[] arrDepTime = new ArrivalDeparture[N];
				for(int i=0; i<N;i++)
					arrDepTime[i] = new ArrivalDeparture();
				int time = -1;
				for (int i = 0; i < N; i++) {					
					if (discovered[i] == false) {
						time = arrivalDeparture(graph, i, discovered,arrDepTime,time);
					}
				}
				for(int i = 0; i<arrDepTime.length;i++) {
					int at = arrDepTime[i].aTime;
					int dt = arrDepTime[i].dTime;
					if(at !=0 || dt!= 0)
						System.out.println(i+"->"+"("+at+","+dt+")");
				}
	}

	private static int arrivalDeparture(Graph graph, int v, boolean[] discovered,
			ArrivalDeparture[] arrDepTime, int time) {
		discovered[v] = true;
		arrDepTime[v].aTime = ++time;
		List<Integer> adjList = graph.adjList.get(v);
		for(int u : adjList) {
			if(!discovered[u]) {
				discovered[u] = true;
				time = arrivalDeparture(graph,u,discovered,arrDepTime,time);
			}			
		}
		arrDepTime[v].dTime = time;
		return time;	
	}

	private static void DFSRec(Graph graph, int v, boolean[] discovered) {
		discovered[v] = true;
		// print current node
		System.out.print(v + " ");
		// do for every edge (v -> u)
		for (int u : graph.adjList.get(v))
		{
			// u is not discovered
			if (!discovered[u]) {
				DFSRec(graph, u, discovered);
			}
		}		
	}

	private static void DFSItr(Graph graph, int v, boolean[] discovered) {
		Stack<Integer> s = new Stack();
		s.push(v);
		while(!s.isEmpty()) {
			int curr = s.pop();
			if(!discovered[curr]) {
				discovered[curr] = true;
				System.out.print(curr+" ");
				List<Integer> adj = graph.adjList.get(curr);
				for(int i = adj.size()-1; i>=0; i--) {
					if(!discovered[adj.get(i)])
						s.push(adj.get(i));
				}
			}
		}
		
	}

	private static void BFSRec(Graph graph, Queue<Integer> q, boolean[] discovered) {
		if(q.isEmpty())
			return;
		int c = q.poll();
		discovered[c] = true;
		System.out.print(c+" ");
		for(int d: graph.adjList.get(c)) {
				if(discovered[d] == false) {
					discovered[d] = true;
					q.offer(d);
				}
		}
		BFSRec(graph,q,discovered);
	}
		

	private static void BFSItr(Graph graph, int v, boolean[] discovered) {
		discovered[v] = true;
		Queue<Integer> q = new LinkedList();
		q.add(v);
		while(!q.isEmpty()) {
			int c = q.poll();
			System.out.print(c+" ");
			for(int d: graph.adjList.get(c)) {
				if(discovered[d] == false) {
					discovered[d] = true;
					q.offer(d);
				}
			}
		}
		
	}

}
