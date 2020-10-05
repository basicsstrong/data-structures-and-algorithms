package com.basicsstrong.algorithm.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {

		solvePuzzle(4, 'X', 'Y', 'Z');

	}

	static void solvePuzzle(int n, char from, char to, char aux) {

		if (n == 1) {
			
			System.out.println("Moving the disk 1 from " + from + " to the " + to + " rod.");
			
		} else {
			
			solvePuzzle(n - 1, from, aux, to);
			System.out.println("Moving the disk " + n + " from " + from + " to the " + to + " rod.");
			solvePuzzle(n - 1, aux, to, from);
		}

	}

}
