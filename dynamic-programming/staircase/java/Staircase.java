package com.basicsstrong.algorithm.dynamicprogramming;

public class Staircase {

	public static void main(String[] args) {
		int[] dp = new int[5];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
	//	System.out.println(ways(4,3,dp));
		System.out.println(waysBottomUp(4,3));
	}
	
	
	//Recursive Approach
	static int ways(int n, int k){
		 if(n==0){
		   return 1;
		 }
		 if(n<0)
		   return 0;
		 
		int ans=0;
		for(int j=1; j<=k;j++)
		   ans += ways(n-j,k);

		return ans;
	}
	
	
	//Dynamic Programming : Top Down Approach
	static int waysTopDown(int n,int k,int[] dp){
		 if(n==0){
		   dp[n] = 1;
		   return 1;
		 }
		 if(n<0){
		   return 0;
		 }
		 if(dp[n]!=-1){
		   return dp[n];
		 }
		dp[n] = 0;
		for(int j=1; j<=k;j++) {
		   dp[n] += waysTopDown(n-j,k,dp);
		}
		 return dp[n];
		} 
	
	
	//Dynamic Programming : Bottom Up Approach
	static int waysBottomUp(int n, int k){
		int[] dp = new int[n+1];
		dp[0] = 1;

		for(int step=1; step<=n; step++){
			dp[step] = 0;
			
			for(int j=1; j<=k; j++){
			   if(step-j>=0)
			   dp[step] += dp[step-j];
			}
		
		}
		return dp[n];
	}

}

