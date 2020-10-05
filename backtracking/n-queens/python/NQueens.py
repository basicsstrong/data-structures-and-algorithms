

def save_queens(board, col, size):

    if col >= size:
        return True

    for i in range(size):
        if is_safe(board, i, col, size):
            board[i][col] = 1

            if save_queens(board, col+1,size):
                return True

            #backtrack
            board[i][col] = 0

    return False



def is_safe(board, row, col, size):
    # No queen horizontally..row is same
    for i in range(col):
        if board[row][i] == 1:
            return False

    #upper half
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    #lower half
    for i, j in zip(range(row, size, 1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    return True



board = [[0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0]
         ]

