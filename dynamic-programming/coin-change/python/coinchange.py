import sys

# Recursive Approach
def min_coins(coins, n, total):
    if total == 0:
        return 0

    result = sys.maxsize
    for i in range(n):
        if coins[i] <= total:
            sub_result = min_coins(coins, n, total - coins[i])
            if sub_result != sys.maxsize and sub_result + 1 < result:
                result = sub_result + 1
    return result


# DP : Top Down Approach
def min_coins_top_down(coins, n, total, table):
    if total == 0:
        return 0

    if total in table:
        return total

    result = sys.maxsize
    for i in range(n):
        if coins[i] <= total:
            sub_result = min_coins_top_down(coins, n, total - coins[i], table)
            if sub_result != sys.maxsize and sub_result + 1 < result:
                result = sub_result + 1
    table[total] = result
    return result


# DP : Bottom Up Approach
def min_coins_bottom_up(coins, n, total):
    table = [0 for k in range(total+1)]

    table[0] = 0

    for i in range(1, total+1):
        table[i] = sys.maxsize

    for i in range(1, total + 1):
        for j in range(n):
            if coins[j] <= i:
                sub_result = table[i-coins[j]]
                if sub_result != sys.maxsize and sub_result + 1 < table[i]:
                    table[i] = sub_result + 1
    return table[total]


if __name__ == '__main__':
    coins = [1, 3, 5, 2]
    n = len(coins)
    total = 9
    min_number = min_coins(coins, n, total)

    table = [[0 for x in range(n+1)] for x in range(total+1)]
    min = min_coins_top_down(coins, n, total, table)

    min_no = min_coins_bottom_up(coins, n, total)

    print('Minimum coins needed : ' , min_no , ' coins');
