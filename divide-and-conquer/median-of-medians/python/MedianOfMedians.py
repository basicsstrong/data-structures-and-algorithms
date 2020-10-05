from math import ceil

def find_median(arr):
    n = len(arr)
    median = find_median_util(arr, n/2+1, 0, n-1)
    print(median)


def find_median_util(arr, k, low, high):
    m = partition(arr, low, high)

    length = m - low + 1

    if length == k:
        return arr[m]

    if length > k:
        return find_median_util(arr, k, low, m-1)
    else:
        return find_median_util(arr, k-length, m+1, high)


def partition(arr, low, high):
    pivot = get_pivot_val(arr, low, high)

    while low < high:
        while arr[low] < pivot:
            low += 1
        while arr[high] > pivot:
            high -= 1

        if arr[low] == arr[high]:
            low += 1

        # swap

        elif low < high:
            temp = arr[low]
            arr[low] = arr[high]
            arr[high] = temp

    return high


def get_pivot_val(arr, low, high):

    if high - low + 1 <= 9:
        sorted(arr)
        return arr[int(len(arr)/2)]

    medians = [0] * int(ceil(( high - low +1 )/5))

    median_index = 0

    while high >= low:

        temp = [0]* min(5, (high - low + 1))

        for i in range(0, len(temp)):
            if low <= high :
                temp[i] = arr[low]
                low += 1

        sorted(temp)

        medians[median_index] = temp[int(len(temp)/2)]
        median_index += 1

    return get_pivot_val(medians, 0, len(medians) - 1)


arr = [25, 24, 33, 39, 3, 18, 19, 31, 23, 49, 45, 16, 1, 29, 40, 22, 15, 20, 24, 4, 13,  34]
find_median(arr)