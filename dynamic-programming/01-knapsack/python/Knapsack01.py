# DP : Top down Approach
def get_max_profit_td(weight, price, n, capacity, values):

    if n == 0 or capacity == 0:
        values[n-1][capacity-1] = 0
        return 0

    if values[n-1][capacity-1] != -1:
        return values[n-1][capacity-1]

    incl = 0
    excl = 0

    if weight[n-1] <= capacity:
        incl = price[n-1] + get_max_profit_td(weight, price, n-1, capacity - weight[n-1], values)
    excl = get_max_profit_td(weight, price, n-1, capacity, values)

    values[n-1][capacity-1] = max(incl, excl)
    return values[n-1][capacity-1]


# DP : Bottom Up Approach
def get_max_profit_bu(weight, price, n, capacity):

    values = [[0 for i in range(capacity+1)] for i in range(n+1)]

    for i in range(n+1):
        for j in range(capacity+1):
            if i == 0 or j == 0 :
                values[i][j] = 0
            else:
                incl = 0
                excl = 0
                if weight[i-1] <= j:
                    incl = price[i-1] + values[i-1][j- weight[i-1]]
                excl = values[i-1][j]
                values[i][j] = max(incl, excl)
    return values[n][capacity]


weight = [7, 5, 4]
price = [15, 8, 8]
capacity = 10
n = len(weight)

values = [[-1 for i in range(capacity+1)] for i in range(n+1)]
print(get_max_profit_bu(weight, price, n, capacity))
