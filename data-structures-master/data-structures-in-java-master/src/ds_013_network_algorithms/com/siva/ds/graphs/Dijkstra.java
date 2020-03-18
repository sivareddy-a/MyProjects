package com.siva.ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	public static void main(String[] args) {
		List<WEdge> edges = Arrays.asList(
				new WEdge(0, 1, 10), new WEdge(0, 4, 3),
				new WEdge(1, 2, 2), new WEdge(1, 4, 4),
				new WEdge(2, 3, 9), new WEdge(3, 2, 7),
				new WEdge(4, 1, 1), new WEdge(4, 2, 8),
				new WEdge(4, 3, 2)
		);

		// Set number of vertices in the graph
		final int N = 5;

		// construct graph
		WGraph graph = new WGraph(edges, N);

		shortestPath(graph, 0, N);

	}

	private static void shortestPath(WGraph graph, int src, int V) {
		Queue<WNode> pq = new PriorityQueue<WNode>(
				(l,r) -> l.weight-r.weight);
		int[] parent = new int[V];
		boolean[] done = new boolean[V];
		List<Integer> dist = new ArrayList<>(
				Collections.nCopies(V, Integer.MAX_VALUE));
		dist.set(src, 0);
		WNode srcNode = new WNode(src,0);
		pq.add(srcNode);
		parent[src] = -1;
		while(!pq.isEmpty()) {
				// System.out.println("pq size = "+pq.size());
				WNode curr = pq.poll();
				int currvertex = curr.vertex;
				int currweight = curr.weight;
				WNode node;
				List<WEdge> adjLsit = graph.adjList.get(currvertex);
				// System.out.println("adjLsit size = "+adjLsit.size());
				for(WEdge eachEdge : adjLsit) {
					int v = eachEdge.dest;
					int w = eachEdge.weight;
					if(!done[v] && currweight + w <= dist.get(v)) {
						dist.set(v, currweight + w);
						node = new WNode(v,currweight + w);
						pq.add(node);
						parent[v] = currvertex;
					}				
				}
				done[currvertex] = true;
		}
		System.out.println("::::::::::::RESULTS:::::::::::");
		System.out.println("src   dest   distance   path");
		for(int i=0; i<dist.size(); i++) {
			System.out.printf("%3d%6d%10d\t%s", src,i,dist.get(i),getPath(parent,i));
			System.out.println();
		}
	}

	private static String getPath(int[]parent, int i) {
		String path = "";
		if(i>=0) {
			path += " "+getPath(parent,parent[i]);
			path+=i+" ";
		}
		return path;
	}
}
