
def solve_maze(maze, x, y, solution, n):

    if x == n-1 and y == n-1 and maze[x][y] == 1:
        solution[x][y] = 1
        return True

    if is_safe(maze, x, y, n):
        solution[x][y] = 1

        #x - dir, x is rows, downwards
        if solve_maze(maze, x+1, y, solution, n):
            return True
        #Y-dir, y is columns, horizontally ->
        if solve_maze(maze, x, y+1, solution, n):
            return True

        #backtrack
        maze[x][y] = 0
        return False

    return False


def is_safe(maze, x, y, n):

    if 0 <= x < n and 0 <= y < n and maze[x][y] == 1:
        return True
    return False


maze = [[1, 1, 0, 0],
        [1, 1, 0, 1],
        [1, 1, 0, 0],
        [0, 1, 1, 1]]

solution = [[0 for j in range(4)] for i in range(4)]

n = len(maze)

if solve_maze(maze, 0, 0, solution, n):
    for i in solution:
        for j in i:
            print(str(j), ' ', end= ' ')
        print(' ')