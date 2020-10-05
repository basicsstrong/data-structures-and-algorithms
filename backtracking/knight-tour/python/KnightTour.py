global path_x, path_y, n
path_x = [2, 1, -1, -2, -2, -1, 1, 2]
path_y = [1, 2, 2, 1, -1, -2, -2, -1]
n = 8


def knight_tour(board, row, col, step):

    if step == n**2:
        return True

    for index in range(n):

        row_new = row + path_x[index]
        col_new = col + path_y[index]

        if move_is_valid(board, row_new, col_new):
            board[row_new][col_new] = step
            if knight_tour(board, row_new, col_new, step+1):
                return True
            board[row_new][col_new] = -1
    return False


def move_is_valid(board, row, col):
    if 0 <= row < n and 0 <= col < n and board[row][col] == -1:
        return True
    return False


board = [[-1 for i in range(n)] for i in range(n)]
board[0][0] = 0
step = 1

if knight_tour(board, 0, 0, step):
    for i in range(n):
        for j in range(n):
            print(board[i][j], ' ', end= ' ')
        print(' ')
else:
    print('Solution does not exist!')

