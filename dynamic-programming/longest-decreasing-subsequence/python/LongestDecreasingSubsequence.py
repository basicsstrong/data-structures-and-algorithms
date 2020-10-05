import sys

#recursive
def get_lds(nums, i, prev):
    if i == len(nums):
        return 0
    incl = 0
    if nums[i] < prev:
        incl = 1 + get_lds(nums, i+1, nums[i])
    excl = get_lds(nums, i+1, prev)
    return max(incl, excl)


# DP: Top Down
def get_lds_top_down(nums, prev_index, curr, dp):
    if curr == len(nums):
        return 0

    if dp[prev_index+1][curr] > 0:
        return dp[prev_index+1][curr]

    incl = 0
    if prev_index < 0 or nums[curr] < nums[prev_index]:
        incl = 1 + get_lds_top_down(nums, curr, curr+1, dp)
    excl = get_lds_top_down(nums, prev_index, curr+1, dp)
    dp[prev_index+1][curr] = max(incl, excl)
    return dp[prev_index+1][curr]


# DP: Bottom Up
def get_lds_bottom_up(nums):
    if len(nums) == 0:
        return 0
    max_lds = [1] * len(nums)

    max_so_far = 1
    for j in range(1, len(nums)):
        for i in range(j):
            if nums[j] < nums[i]:
                max_lds[j] = max(max_lds[j], max_lds[i]+1)
        max_so_far = max(max_so_far, max_lds[j])
    return max_so_far


if __name__ == '__main__':
    nums = [20, 8, 12, 16, 10, 9, 18, 7]
    print(get_lds(nums, 0, sys.maxsize))

    dp = [[-1 for i in range(len(nums))] for i in range(len(nums) + 1)]
    print(get_lds_top_down(nums, -1, 0, dp))

    print(get_lds_bottom_up(nums))