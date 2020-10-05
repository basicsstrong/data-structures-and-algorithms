package com.basicsstrong.algorithm.greedy;

public class DijkstraAlgo {

 public static void main(String[] args) {

	 int adjacencyMatrix[][]= {
			 {0, 3, 5, 6, 0, 8, 0},
			 {3, 0, 0, 4, 2, 0, 5},
			 {5, 0, 0, 0, 0, 4, 0},
			 {6, 4, 0, 0, 0, 1, 6},
			 {0, 2, 0, 0, 0, 0, 10},
			 {8, 0, 6, 1, 0, 0, 8},
			 {0, 8, 0, 6, 10, 8, 0}
		}; 
	 
	 dijkstra(adjacencyMatrix);
	 

	}

	private static void dijkstra(int[][] adjacencyMatrix) {
		
		int v = adjacencyMatrix.length;
		
		boolean[] visited = new boolean[v];
		
		int[] distance = new int[v];
		
		//start
		
		distance[0] = 0;
		
		for (int i = 1; i < v; i++) {
			
			distance[i] = Integer.MAX_VALUE;
			
		}
		
		for (int i = 0; i < v-1 ; i++) {
			
			int minVertex = findMinVertex(distance, visited);
			
			visited[minVertex] = true;
			
			for(int j = 0; j < v; j++) {
				
				if(adjacencyMatrix[minVertex][j]!= 0 && !visited[j]) {
					int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
					
					if(newDist < distance[j]) {
						distance[j] = newDist;
					}
				}
				
			}
			
		}
		
		for(int i = 0; i < v; i++) {
			System.out.println(i + " "+ distance[i]);
		}
		

	}

	private static int findMinVertex(int[] distance, boolean[] visited) {
		
		
		int minVertex = -1;
		
		for(int i = 0; i < distance.length; i++) {
			if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
					minVertex = i;
		}
		return minVertex;
	}

}
