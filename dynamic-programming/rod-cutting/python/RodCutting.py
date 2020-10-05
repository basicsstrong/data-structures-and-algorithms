import sys


# Recursive Approach (exponential)
def rod_cut(price, n):
    if n == 0:
        return 0
    max_revenue = -sys.maxsize
    for i in range(1, n + 1):
        max_revenue = max(max_revenue, price[i - 1] + rod_cut(price, n - i))
    return max_revenue


# DP : Top Down Approach O(n^2)
def rod_cut_topdown(price, n, dp):
    if n == 0:
        return 0

    if dp[n - 1] > 0:
        return dp[n - 1]

    max_revenue = -sys.maxsize
    for i in range(1, n + 1):
        max_revenue = max(max_revenue, price[i - 1] + rod_cut_topdown(price, n - i, dp))
    dp[n - 1] = max_revenue
    return dp[n - 1]


# DP : Bottom Up Approach O(n^2)
def rod_cut_bottomup(price, n):
    revenues = [0] * (n + 1)
    # revenues[0] = 0

    max_revenue = -sys.maxsize
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            max_revenue = max(max_revenue, price[j - 1] + revenues[i - j])
        revenues[i] = max_revenue
    return revenues[n]


if __name__ == '__main__':
    price = [4, 5, 8, 9]
    size = len(price)
    print('max revenue', rod_cut(price, size))

    dp = [0] * size
    print('max revenue (top down):', rod_cut_topdown(price, size, dp))

    print('max revenue (bottom up):', rod_cut_bottomup(price, size))
