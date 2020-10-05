package com.basicsstrong.algorithm.dynamicprogramming;

import java.util.Arrays;

public class LDS {
	static int count=0;

	public static void main(String[] args)
	{
		int[] nums = { 20, 8, 12, 16, 10, 9, 18, 7 };

		System.out.println("Recursive: Length of LDS " + getLDS(nums, 0, Integer.MAX_VALUE));

		int[][] dp = new int[nums.length+1][nums.length];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		System.out.println("DP top down: Length of LDS " + getLDS(nums,-1, 0, dp));

		System.out.println("DP bottom up: Length of LDS " + getLDS(nums));
	}

	
	//Recursive Approach
	public static int getLDS(int[] nums, int i, int prev) {

		if (i == nums.length) {
			return 0;
		}

		int incl = 0;
		if (nums[i] < prev) {
			incl = 1 + getLDS(nums, i + 1, nums[i]);
		}

		int excl = getLDS(nums, i + 1, prev);
  	return Integer.max(incl, excl);
	}

	
	//DP : Top Down Approach
  	public static int getLDS(int[] nums, int prevIndex, int curr, int[][] dp) {
    	if (curr == nums.length) {
			return 0;
		}

		if(dp[prevIndex+1][curr]>0) {
			return dp[prevIndex+1][curr];
		}

	 	int incl = 0;
		if (prevIndex<0 || nums[curr] < nums[prevIndex]) {
			incl = 1 + getLDS(nums,curr,curr+1,dp);
		}

		int excl = getLDS(nums,prevIndex,curr+1,dp);

		dp[prevIndex+1][curr]= Integer.max(incl, excl);
		return dp[prevIndex+1][curr];
	}

  	
  	//DP : Bottom UP Approach
	public static int getLDS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] maxLds = new int[nums.length];
		Arrays.fill(maxLds, 1);

		int maximumSoFar = 1;

		for (int j = 1; j < nums.length; j++) {
			for (int i = 0; i < j; i++) {
				if (nums[j] < nums[i]) {
					maxLds[j] = Math.max(maxLds[j], maxLds[i] + 1);
				}
			}

			maximumSoFar = Math.max(maximumSoFar, maxLds[j]);
		}
		return maximumSoFar;
	}


}
