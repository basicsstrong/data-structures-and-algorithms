def max_sum_subarray(arr):
    global_max = arr[0]
    local_max = arr[0]
    for i in range(1, len(arr)):
        local_max = max(local_max + arr[i], arr[i])
        global_max = max(global_max, local_max)
    return global_max


arr = [-2, -1, 3, -2, 4, 3, -3, 5]
max_sum = max_sum_subarray(arr)
print(max_sum)
