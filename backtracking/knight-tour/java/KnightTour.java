package com.basicsstrong.algorithm.backtracking;

public class KnightTour {

	private static int[] pathRow = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int[] pathCol = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	//8 * 8 board is default/ideal for Knight tour problem
	static int n = 8;

	public static void main(String[] args) {

		int[][] board = { 
						{ 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0 } 
						};
		
		int len = board.length;
		
		//n can be changed here if the matrix is not 8 * 8
		n = len;
		
		knightTour(board, 0, 0, 0);

	}

	private static boolean knightTour(int[][] board, int row, int col, int step) {
		
		if(step == n*n-1) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]+" ");
				}
				
				System.out.println();
				
			}
			
			return true;
		}
		
		for (int i = 0; i < pathRow.length; i++) {
			
			int newRow = row + pathRow[i];
			int newCol = col + pathCol[i];
			
			if(isValidMove(board, newRow, newCol)) {
				step++;
				board[newRow][newCol] = step;
				
				if(knightTour(board, newRow, newCol, step)) {
					return true;
				}
				
				//backtrack
				
				step--;
				board[newRow][newCol] = 0;
				
			}
			
		}
		
		return false;
		
	}

	private static boolean isValidMove(int[][] board, int newRow, int newCol) {
		
		return (newRow >= 0 && newRow < 8 &&
				newCol >= 0 && newCol < 8 &&
				board[newRow][newCol] == 0);
		
	}

}
