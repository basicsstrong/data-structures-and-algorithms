const dictionary = ["RAY", "APPLE", "FAKE", "BOOKS"]

const dim1 = 4, dim2 = 4

var boggle = [
    ['T','Y','R','S'],
	['N','U','A','K'],
	['Z','F','E','O'],
	['A','C','B','O']
]
		
var visited = [];
for(let i = 0; i < dim1; i++) {
    visited.push(new Array(dim2).fill(0));
}
		
for (let i = 0; i < dim1; i++) {
    for (let j = 0; j < dim2; j++) {
        findWords(boggle, visited, i, j, '');
    }
}

function findWords(boggle, visited, i, j, word) {
		
		visited[i][j] = 1;
		word= word + boggle[i][j];
		
		if(dictionary.includes(word)) {
			console.log(word);
		}
		
		
		for (let row = i-1; row <= i+1; row++) {
			for (let col = j-1; col <= j+1; col++) {
				if(isValid(row, col, visited)) {
					
					findWords(boggle, visited, row, col, word);
					
				}
			}
		}
		
		visited[i][j] = 0;
	}

	function isValid(row, col, visited) {
		return (row >= 0 && row < dim1 &&
				col >= 0 && col < dim2 &&
				visited[row][col] == 0);
	}
