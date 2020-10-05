const nums = [20, 8, 12, 16, 10, 9, 18, 7];

console.log("Length of LDS: " + getLds(nums, 0, Number.MAX_SAFE_INTEGER));

var arr = new Array();

for (let i = 0; i < nums.length + 1; i++) {
    arr.push(new Array(nums.length).fill(-1))
}

console.log("Top Down- Length of LDS: " + getLdsTopDown(nums, -1, 0, arr));

console.log("Bottom up- Length of LDS: " + getLdsBottomUp(nums));

//O(n^2)
function getLdsBottomUp(nums) {
    if (nums.length == 0)
        return 0;

    var maxLds = new Array(nums.length).fill(1);

    let maxSoFar = 1;
    for (let j = 1; j < nums.length; j++) {
        for (let i = 0; i < j; i++) {
            if (nums[j] < nums[i])
                maxLds[j] = Math.max(maxLds[j], maxLds[i] + 1);
        }
        maxSoFar = Math.max(maxSoFar, maxLds[j]);
    }
    return maxSoFar;
}

//O(n^2)
function getLdsTopDown(nums, prevIndex, curr, arr) {

    if (curr == nums.length)
        return 0;

    if (arr[prevIndex + 1][curr] > 0)
        return arr[prevIndex + 1][curr];

    let incl = 0;
    if (prevIndex < 0 || nums[curr] < nums[prevIndex]) {
        incl = 1 + getLdsTopDown(nums, curr, curr + 1, arr);
    }

    let excl = getLdsTopDown(nums, prevIndex, curr + 1, arr);

    //memoization
    arr[prevIndex + 1][curr] = Math.max(incl, excl);

    return arr[prevIndex + 1][curr];
}

//O(2^n)
function getLds(nums, i, prev) {

    if (i == nums.length)
        return 0;

    let incl = 0;
    if (nums[i] < prev)
        incl = 1 + getLds(nums, i + 1, nums[i]);

    let excl = getLds(nums, i + 1, prev);

    return Math.max(incl, excl);
}

