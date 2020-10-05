
const intervals = [
    [0, 3],
    [0, 15],
    [5, 10],
    [7, 12],
    [11, 16],
    [12, 14],
    [16, 20]
];

var optimalSchedule = schedule(intervals);
console.log(optimalSchedule);

function schedule(intervals) {

    optimalIntervalSet = new Array();

    intervals.sort((interval1, interval2) => {
        return interval1[1] - interval2[1];
    })

    var lastFinishTime = Number.MIN_SAFE_INTEGER;

    intervals.forEach((interval) => {
        const start = interval[0];
        if (start > lastFinishTime) {
            const end = interval[1];

            optimalIntervalSet.push(interval);
            lastFinishTime = end;
        }
    });

    return optimalIntervalSet;
}


