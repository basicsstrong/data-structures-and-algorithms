package com.basicsstrong.algorithm.famousalgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class KahnsAlgorithm {
	
	static class Graph{
		
		int V;
		List<Integer>[] adj;
		
		public Graph(int V) {
			this.V = V;
			adj = new ArrayList[V];
			
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
		}
		
		public void addEdge(int u, int v) {
			adj[u].add(v);  
		}

		public void topologicalSort() {
			
			int[] indegree = new int[V];
			
			for (int i = 0; i < V; i++) {
				ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
				
				//indegree
				for (int vertex : temp) {
					
					indegree[vertex]++;
					
				}
			}
			
			//the vertex that we are selecting
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < V; i++) {
				if(indegree[i] == 0)
					q.add(i);
			}
			
			//keep track of the number selected vertices
			int c = 0;
			
			Vector<Integer> linearOrder = new Vector<Integer>();
			
			while(!q.isEmpty()) {
				int x = q.poll();
				linearOrder.add(x);
				
				for (Integer vertex : adj[x]) {
					if(--indegree[vertex] == 0)
						q.add(vertex);
				}
				c++;
			}
			
			if(c != V) {
				System.out.println("Graph contains -ve cycle.");
				return;
			}
			
			System.out.println(" The Linear Order is :");
			for (int i : linearOrder) {
				
				System.out.println(i + " ");
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		
		g.topologicalSort();
		
		//1,4,2,5,3
		
	}
	
	
}



