package com.basicsstrong.algorithm.famousalgorithm;

public class Graph {
	
	class Edge{
		int s, d, w;
		
		Edge(){
			s = w = d = 0;
		}
		
	}
	
	int V, E;
	Edge edge[];
	
	
	Graph(int v, int e){
		
		this.V = v;
		this.E = e;
		
		
		edge = new Edge[e];
		
		for (int i = 0; i < e; i++) {
			
			edge[i] = new Edge();
		}

		
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(6, 9);
		
		//A = 0, B = 1, C= 2, D = 3, E = 4, F = 5
		
		//AB, 01
		
		g.edge[0].s = 0;
		g.edge[0].d = 1;
		g.edge[0].w = 8;
		
		//AF, 05
		
		g.edge[1].s = 0;
		g.edge[1].d = 5;
		g.edge[1].w = 5;
		
		//AD, 03
		
		g.edge[2].s = 0;
		g.edge[2].d = 3;
		g.edge[2].w = 3;
		
		//BC 1,2
		g.edge[3].s = 1;
		g.edge[3].d = 2;
		g.edge[3].w = 6;


		//CE 2,4
		g.edge[4].s = 2;
		g.edge[4].d = 4;
		g.edge[4].w = 4;
		
		//DE 3,4
		g.edge[5].s = 3;
		g.edge[5].d = 4;
		g.edge[5].w = -1;
		
		//FB 5,1
		g.edge[6].s = 5;
		g.edge[6].d = 1;
		g.edge[6].w = -4;
		
		//FC 5,2
		g.edge[7].s = 5;
		g.edge[7].d = 2;
		g.edge[7].w = -1;
		
		//FE 5,4
		g.edge[8].s = 5;
		g.edge[8].d = 4;
		g.edge[8].w = -3;
		
		bellmanFord(g, 0);

	}

	private static void bellmanFord(Graph g, int s) {
		
		int V = g.V;
		int E = g.E;
		int[] dist = new int[V];
		
		
		//∞
		for (int i = 0; i < dist.length; i++) {
			
			dist[i] = Integer.MAX_VALUE;
			dist[s] = 0;
			
		}
		
		//Relax V-1 times
		
		for (int i = 0; i < V; ++i) {
			
			for (int j = 0; j < E; ++j) {
				
				int u = g.edge[j].s;
				int v = g.edge[j].d;
				int c = g.edge[j].w;
				
				if(dist[u] != Integer.MAX_VALUE && dist[u] + c < dist[v])
					dist[v] = dist[u] + c;
				
			}
			
		}
		
		//-ve
		
		for (int j = 0; j < E; ++j) {
			
			int u = g.edge[j].s;
			int v = g.edge[j].d;
			int c = g.edge[j].w;
			
			if(dist[u] != Integer.MAX_VALUE && dist[u] + c < dist[v]) {				
				System.out.println("Graph containes -ve cycle.");
				return;
			}
			
			
		}
		
		//print
		
		for (int i = 0; i < V; i++) {
			
			System.out.println(i + " : "+ dist[i]);
			
		}
		
		
		
	}

}
