package com.basicsstrong.algorithm.dynamicprogramming;

public class Knapsack01 {

	public static void main(String[] args) {

		int[] weight = { 7, 4, 4 };
		int[] price = { 15, 8, 8 };

		int capacity = 10;

		int n = weight.length;

		//recursion
		System.out.println(getMaxProfit(weight, price, n, capacity));

		int[][] values = new int[n + 1][capacity + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= capacity; j++) {
				values[i][j] = -1;
			}
		}

		//top down
		System.out.println(getMaxProfit(weight, price, n, capacity, values));

		//bottom up
		System.out.println(getMaxProfitBottomUp(weight,price,n,capacity));
	}

	
	//Recursive Approach
	private static int getMaxProfit(int[] weight, int[] price, int n, int capacity) {

		if (n == 0 || capacity == 0) {
			return 0;
		}

		int incl = 0, excl = 0;

		if (weight[n - 1] <= capacity) {

			incl = price[n - 1] + getMaxProfit(weight, price, n - 1, capacity - weight[n - 1]);
		}
		excl = getMaxProfit(weight, price, n - 1, capacity);

		return Math.max(incl, excl);
	}

	// DP : Top Down Approach
	private static int getMaxProfit(int[] weight, int[] price, int n, int capacity, int[][] values) {

		if (n == 0 || capacity == 0) {
			values[n][capacity] = 0;
			return 0;
		}

		if (values[n - 1][capacity] != -1)
			return values[n - 1][capacity];

		int incl = 0, excl = 0;

		if (weight[n - 1] <= capacity) {

			incl = price[n - 1] + getMaxProfit(weight, price, n - 1, capacity - weight[n - 1], values);
		}
		excl = getMaxProfit(weight, price, n - 1, capacity, values);

		values[n - 1][capacity] = Math.max(incl, excl);
		return values[n - 1][capacity];
	}

	// DP : Bottom Up Approach
	private static int getMaxProfitBottomUp(int[] weight, int[] price, int n, int capacity) {

		int[][] values = new int[n + 1][capacity + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {
					values[i][j] = 0;
				} else {
					int incl = 0, excl = 0;
					if (weight[i - 1] <= j)
						incl = price[i - 1] + values[i - 1][j - weight[i - 1]];

					excl = values[i - 1][j];

					values[i][j] = Math.max(incl, excl);
				}
			}
		}
		return values[n][capacity];
	}

}
