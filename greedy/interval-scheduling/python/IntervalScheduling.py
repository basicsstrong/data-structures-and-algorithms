
def schedule(intervals):
    optimal_interval_set = []

    #sorted(intervals, key=intervals[1])

    intervals.sort(key=lambda i: i[1])

    last_finish_time = float('-inf')

    for interval in intervals:

        start = interval[0]

        if start > last_finish_time:
            end = interval[1]

            optimal_interval_set.append(interval)

            last_finish_time = end

    return optimal_interval_set


intervals = [
    [0, 3],
    [0, 15],
    [5, 10],
    [7, 12],
    [11, 16],
    [12, 14],
    [16, 20],
]

optimal_schedule = schedule(intervals)

for ele in optimal_schedule:
    for i in range(len(ele)):
        print(ele[i])
    print()
