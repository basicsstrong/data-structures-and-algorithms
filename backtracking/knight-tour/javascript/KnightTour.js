const pathRow = [2, 1, -1, -2, -2, -1, 1, 2 ]
const pathCol = [1, 2, 2, 1, -1, -2, -2, -1 ]
const n = 8
const board = [];
for(let i = 0; i < n; i++){
	board.push(new Array(n).fill(0));
}

knightTour(board, 0, 0, 0);

function knightTour(board, row, col, step){

	if ( step == n*n - 1){
		
		for(let i = 0; i < n; i++){
			str = '';
			for(let j = 0; j < n; j++){
				str += board[i][j] + ' ';
			}
			console.log(str);
		}

		return true;
	}


	for(let i = 0; i < pathRow.length; i++){
		let newRow = row + pathRow[i];
		let newCol = col + pathCol[i];

		if(isValidMove(board, newRow, newCol)){
			step++;
			board[newRow][newCol] = step;

			if(knightTour(board, newRow, newCol, step))
				return true;

			//backtrack
			step--;
			board[newRow][newCol] = 0;
		}
	}
	return false;
}

function isValidMove(board, newRow, newCol){
	return (newRow >= 0 && newRow < n &&
		newCol >= 0 && newCol < n && 
		board[newRow][newCol] == 0);
}
