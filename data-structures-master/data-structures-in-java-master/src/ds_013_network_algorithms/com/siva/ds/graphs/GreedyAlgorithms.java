package com.siva.ds.graphs;

import java.util.ArrayList;
import java.util.List;

class WEdge
{
	int src, dest, weight;

	public WEdge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(" + src + ", " + dest + ", " + weight + ")";
	}
};

//Data structure to store heap nodes
class WNode
{
	int vertex, weight;

	public WNode(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
};

//class to represent a graph object
class WGraph
{
	// A List of Lists to represent an adjacency list
	List<List<WEdge>> adjList = null;

	// Constructor
	WGraph(List<WEdge> edges, int N)
	{
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (WEdge edge: edges) {
			adjList.get(edge.src).add(edge);
		}
	}
}
public class GreedyAlgorithms {
	public static void main(String[] ar) {
		
	}
}
