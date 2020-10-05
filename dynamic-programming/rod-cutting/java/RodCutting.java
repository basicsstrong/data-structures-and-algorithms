package com.basicsstrong.algorithm.dynamicprogramming;

public class RodCutting {

	public static void main(String[] args) {

		int[] price = new int[] {4,5,8,9};
		int size = price.length;
		
		System.out.println("Max obtainable revenue: "+rodCut(price,size));
		
		int dp[] = new int[size];
		System.out.println("Max obtainable revenue (top down): "+rodCut(price,size,dp));
		
		System.out.println("Max obtainable revenue (bottom up): "+rodCut(price));
	}

	//DP : Bottom Up Approach O(n^2)
	private static int rodCut(int[] price) {

		int[] r = new int[price.length+1];
		r[0] = 0;
		
		int maxRevenue = Integer.MIN_VALUE;
		
		for (int i = 1; i < r.length; i++) {
			for (int j = 1; j <= i; j++) {
				maxRevenue = Math.max(maxRevenue, price[j-1]+r[i-j]);
			}
			r[i] = maxRevenue;
		}
		
		return r[price.length];
	}

	//DP : Top Down Approach O(n^2)
	private static int rodCut(int[] price, int n, int[] dp) {
		if(n==0)
			return 0;
		
		if(dp[n-1]>0)
			return dp[n-1];
		
		int maxRevenue = Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++)
			maxRevenue = Math.max(maxRevenue, price[i-1]+rodCut(price,n-i));
		
		return dp[n-1] = maxRevenue;
	}

	//Recursive Approach (exponential)
	private static int rodCut(int[] price, int n) {

		if(n==0)
			return 0;
		
		int maxRevenue = Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++)
			maxRevenue = Math.max(maxRevenue, price[i-1]+rodCut(price,n-i));
		
		return maxRevenue;
	}

}
