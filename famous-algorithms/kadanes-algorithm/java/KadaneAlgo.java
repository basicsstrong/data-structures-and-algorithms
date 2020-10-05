package com.basicsstrong.algorithm.famousalgorithm;

public class KadaneAlgo{

	public static void main(String[] args) {
		int[] arr = { -2, -1, 3, -2, 4, 3, -3, 5 };
		
		int maxSum = maxSumSubarray(arr);
		
		System.out.println(maxSum);

	}

	private static int maxSumSubarray(int[] arr) {
		
		int globalMax = arr[0];
		int localMax = arr[0];
		
		for(int i = 1; i < arr.length ; i++) {
			
			localMax = Math.max(localMax + arr[i], arr[i]);
			
			globalMax = Math.max(globalMax, localMax);
			
		}
		
		return globalMax;
	}

}
