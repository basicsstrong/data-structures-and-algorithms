package com.basicsstrong.algorithm.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) {

		int[] seq = new int[] {4,3,2,1,5};
		int n= seq.length;
		
		System.out.println("Minimum number of multiplications: "+mcm(seq,1,n-1));
		
		int[][] arr = new int[n][n];
		for (int[] is : arr) {
			Arrays.fill(is, -1);
		}
		
		System.out.println("top down: "+ mcm(seq,1,n-1,arr));
		System.out.println("bottom up: "+ mcm(seq,n));
	}

	// DP : Bottom Up Approach O(N^3)
	private static int mcm(int[] seq, int n) {
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][i] = 0;
		}
		
		for(int len=2; len<n; len++) {
			for(int i=1; i<= n-len; i++) {
				
				int j = i+len-1;
				
				if(j==n) continue;
				
				int minOps = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					minOps = Math.min(minOps, arr[i][k]+arr[k+1][j]+ seq[i-1]*seq[k]*seq[j]);
					arr[i][j] = minOps;
				}
				
			}
		}
		return arr[1][n-1];
		
	}

	//DP : Top Down ApproachO(N^3)
	private static int mcm(int[] seq, int i, int j, int[][] arr) {
		
		if(i==j)
			return arr[i][j]=0;
		
		if(arr[i][j]>=0) {
			return arr[i][j];
		}
		
		int minOps = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++) 
			minOps = Math.min(minOps, mcm(seq,i,k,arr) + mcm(seq,k+1,j,arr) + seq[i-1]*seq[k]*seq[j]);
		
		return arr[i][j]=minOps;
	}

	//Recursive Approach (Exponential)
	private static int mcm(int[] seq, int i, int j) {

		if(i==j)
			return 0;
		
		int minOps = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++) {
			int ops = mcm(seq,i,k) + mcm(seq,k+1,j) + seq[i-1]*seq[k]*seq[j];
			minOps = Math.min(minOps, ops);
		}
		
		return minOps;
	}

}
