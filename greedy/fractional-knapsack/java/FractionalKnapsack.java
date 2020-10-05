package com.basicsstrong.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

	public static void main(String[] args) {
		
        int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50; 
        
        double maxValue = getMaxValue(wt, val, capacity);
        
        System.out.println("The maximum profit possible = "+ maxValue);

	}

	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		
		
		Item[] items = new Item[wt.length];
		
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(wt[i], val[i], i);
		}
		
		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o2.cost.compareTo(o1.cost);
			}
			
		});
		
		double totalVal = 0d;
		
		for (Item item : items) {
			
			int curWt = (int)item.wt;
			int curVal = (int)item.val;
			
			
			if(capacity - curWt >= 0) {
				
				capacity = capacity - curWt;
				totalVal += curVal;
				
			}else {
				
				double fraction = (double)capacity/(double)curWt;
				
				totalVal += curVal * fraction;
				
				break;
				
			}
			
		}
		
		return totalVal;
	}
	
	
	static class Item{
		Double cost;
		double wt, val, ind;
		
		public Item(int wt, int val, int ind) {
			
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			
			this.cost = Double.valueOf(val/wt);
			
		}
	}
}