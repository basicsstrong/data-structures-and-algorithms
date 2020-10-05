def quick_sort(arr, lb, ub):

    if lb < ub:
        index = partition(arr, lb, ub)
        quick_sort(arr, lb, index-1)
        quick_sort(arr, index+1, ub)


def partition(arr, lb, ub):
    pivot = arr[lb]
    left = lb
    right = ub

    while left < right:
        while arr[left] <= pivot and left < (len(arr)-1):
            left += 1

        while arr[right] > pivot and right > 0:
            right -= 1

        if left < right :
            # swap
            temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp

    # swap right with pivot/lb

    temp = arr[lb]
    arr[lb] = arr[right]
    arr[right] = temp

    return right


arr = [10, 1, 67, 20, 56, 34, 43, 90, 54, 8, 0]
n = len(arr)

quick_sort(arr, 0, n-1)

for i in range(n):
    print(arr[i])



