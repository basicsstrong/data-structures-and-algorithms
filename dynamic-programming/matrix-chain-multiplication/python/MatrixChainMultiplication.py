import sys


# Recursive Approach
def mcm(seq, i, j):
    if i == j:
        return 0
    min_ops = sys.maxsize
    for k in range(i, j):
        ops = mcm(seq, i, k) + mcm(seq, k+1, j) + seq[i-1]*seq[k]*seq[j]
        min_ops = min(ops, min_ops)
    return min_ops


# DP : Top Down Approach
def mcm_topdown(seq, i, j, arr):
    if i == j:
        return 0
    if arr[i][j] >= 0:
        return arr[i][j]
    min_ops = sys.maxsize
    for k in range(i, j):
        min_ops = min(min_ops, (mcm_topdown(seq, i, k, arr) + mcm_topdown(seq, k+1, j, arr) + seq[i-1]*seq[k]*seq[j]))
    arr[i][j] = min_ops
    return arr[i][j]


# DP : Bottom Up Approach
def mcm_bottomup(seq, n):
    arr = [[0 for i in range(n)] for i in range(n)]
    for i in range(n):
        arr[i][i] = 0
    for len in range(2, n):
        for i in range(1, n-len+1):
            j = i + len - 1
            if j == n:
                continue
            min_ops = sys.maxsize
            for k in range(i, j):
                min_ops = min(min_ops, (arr[i][k] + arr[k+1][j] + seq[i - 1] * seq[k] * seq[j]))
            arr[i][j] = min_ops
    for i in range(n):
        for j in range(n):
            print(arr[i][j], end=' ')
        print()
    return arr[1][n-1]


if __name__ == '__main__':
    seq = [4, 3, 2, 1, 5]
    n = len(seq)
    print(mcm(seq, 1, n - 1))

    arr = [[-1 for i in range(n)]for i in range(n)]
    print('top down:', mcm_topdown(seq, 1, n-1, arr))

    print('bottom up:', mcm_bottomup(seq, n))
