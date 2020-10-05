package com.basicsstrong.algorithm.recursion;

import java.util.List;

public class ProductSum {

	public static void main(String[] args) {
		
		List<Object> a1 = List.of(2,3);
		List<Object> a3 = List.of(a1, 1);
		List<Object> array = List.of(1, 2, a1, 6, a3, 7);
		
		System.out.println(productSum(array, 1));
		

	}
	
	static int productSum(List<Object> list, int depth) {
		
		int sum = 0;
		
		for (Object object : list) {
			if(object instanceof List) {
				sum += productSum((List<Object>)object, depth + 1);
			}else {
				sum += (int)object;
			}
		}
		
		return sum*depth;
		
	}

}
