
# Recursive Approach
def get_edit_dist(str1, str2, m, n):
    if m == 0 or n == 0:
        return max(m, n)

    ch1 = 1 + get_edit_dist(str1, str2, m, n - 1)
    ch2 = 1 + get_edit_dist(str1, str2, m - 1, n)

    if str1[m-1] == str2[n-1]:
        k = 0
    else:
        k = 1

    ch3 = k + get_edit_dist(str1, str2, m - 1, n - 1)
    return min(ch1, ch2, ch3)


# DP : Top Down Approach
def get_edit_dist_td(str1, str2, m, n, dp):
    if m == 0 or n == 0:
        return max(m, n)

    if dp[m-1][n-1] >= 0:
        return dp[m-1][n-1]

    ch1 = 1 + get_edit_dist_td(str1, str2, m, n - 1, dp)
    ch2 = 1 + get_edit_dist_td(str1, str2, m - 1, n, dp)

    if str1[m - 1] == str2[n - 1]:
        k = 0
    else:
        k = 1

    ch3 = k + get_edit_dist_td(str1, str2, m - 1, n - 1, dp)
    dp[m-1][n-1] = min(ch1, ch2, ch3)
    return dp[m-1][n-1]


# DP : Bottom Up Approach
def get_edit_dist_bu(str1, str2, m, n):
    l_dist = [[0 for i in range(n+1)]for i in range(m+1)]

    for i in range(m):
        l_dist[0][i] = i
    for j in range(n):
        l_dist[j][0] = j
    for i in range(1, m+1):
        for j in range(1, n+1):
            if str1[i - 1] == str2[j - 1]:
                l_dist[i][j] = l_dist[i - 1][j - 1]
            else:
                l_dist[i][j] = min(l_dist[i][j - 1], l_dist[i - 1][j], l_dist[i - 1][j - 1]) + 1;
    return l_dist[m][n]



def editDistDP(str1, str2, m, n): 
    # Create a table to store results of subproblems 
    dp = [[0 for x in range(n + 1)] for x in range(m + 1)] 
  
    # Fill d[][] in bottom up manner 
    for i in range(m + 1): 
        for j in range(n + 1): 
  
            # If first string is empty, only option is to 
            # insert all characters of second string 
            if i == 0: 
                dp[i][j] = j    # Min. operations = j 
  
            # If second string is empty, only option is to 
            # remove all characters of second string 
            elif j == 0: 
                dp[i][j] = i    # Min. operations = i 
  
            # If last characters are same, ignore last char 
            # and recur for remaining string 
            elif str1[i-1] == str2[j-1]: 
                dp[i][j] = dp[i-1][j-1] 
  
            # If last character are different, consider all 
            # possibilities and find minimum 
            else: 
                dp[i][j] = 1 + min(dp[i][j-1],        # Insert 
                                   dp[i-1][j],        # Remove 
                                   dp[i-1][j-1])    # Replace 
  
    return dp[m][n] 


if __name__ == '__main__':
    str1 = 'Base'
    str2 = 'Basic'
    m = len(str1)
    n = len(str2)
    print(get_edit_dist(str1, str2, m, n))

    dp = [[-1 for i in range(n)]for i in range(m)]
    print('top down: ', get_edit_dist_td(str1, str2, m, n, dp))

    print('bottom up: ', get_edit_dist_bu(str1, str2, m, n))
