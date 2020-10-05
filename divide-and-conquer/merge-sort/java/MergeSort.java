package com.basicsstrong.algorithm.divideandconquer;

class MergeSort { 
	
	public static void main(String args[]) 
	{ 
		
		int[] arr = {11, 6, 3, 9, 14, 66, 2};
		
		int len = arr.length;
		
		mergeSort(arr, 0, len-1);
		
		for (int i = 0; i < len; i++) {
			
			System.out.println(arr[i]+ " ");
			
		}
		
	}

	private static void mergeSort(int[] arr, int l, int u) {
		
		if(l < u) {
			
			int m = (l+u)/2;
			
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, u);
			
			merge(arr, l, m, u);
			
		}
		
		
	}

	private static void merge(int[] arr, int l, int m, int u) {
		
		int n1 = m - l + 1;
		int n2 = u - m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < n1; i++) {
			
			left[i] = arr[l + i];
			
		}
		
		for (int i = 0; i < n2; i++) {
			
			right[i] = arr[m+1+i];
		}
		
		
		int i = 0, j = 0, k = l;
		
		while(i < n1 && j < n2) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < n2) {
			
			arr[k] = right[j];
			j++;
			k++;
		}
		
	} 
	
} 


