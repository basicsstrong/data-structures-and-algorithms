#Recursive Approach
def ways(n, k):

    if n == 0:
        return 1
    if n < 0:
        return 0

    ans = 0
    for i in range(1, k+1):
        ans += ways(n-i, k)

    return ans

#Dynamic Programming : Top Down Approach
def ways_top_down(n, k, dp):

    if n == 0:
        dp[n] = 1
        return dp[n]
    if n < 0:
        return 0

    if not dp[n] == -1:
        return dp[n]

    dp[n] = 0
    for i in range(1, k+1):
        dp[n] += ways_top_down(n-i, k, dp)

    return dp[n]

#Dynamic Programming : Bottom Up Approach
def ways_bottom_up(n, k):

    dp = [0] * (n+1)
    dp[0] = 1

    for step in range(1, n+1):
        dp[step] = 0
        for j in range(1, k+1):
            if step - j >= 0:
                dp[step] += dp[step - j]
    return dp[n]


n = 4
steps = 3
dp = [-1]*(n+1)
print(ways_bottom_up(n, steps))