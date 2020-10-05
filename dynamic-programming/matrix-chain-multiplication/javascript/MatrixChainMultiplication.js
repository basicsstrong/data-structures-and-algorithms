
const seq = [4, 3, 2, 1, 5];
var n = seq.length;

console.log("Minimum number of operations: " + mcm(seq, 1, n - 1));

var arr = [];

for (let i = 0; i < n; i++) {
    arr.push(new Array(n).fill(-1));
}


console.log("top down: " + mcmTopDown(seq, 1, n - 1, arr));
console.log("bottom up: " + mcmBottomUp(seq, n));


//DP : Bottom Up Approach O(N^3)
function mcmBottomUp(seq, n) {
    var arr = [];

    for (let i = 0; i < n; i++) {
        arr.push(new Array(n).fill(0));
    }

    for (let len = 2; len < n; len++) {
        for (let i = 1; i <= n - len; i++) {

            let j = i + len - 1;

            if (j == n) continue;

            let minOps = Number.MAX_SAFE_INTEGER;
            for (let k = i; k < j; k++) {
                minOps = Math.min(minOps, arr[i][k] + arr[k + 1][j] + seq[i - 1] * seq[k] * seq[j]);
                arr[i][j] = minOps;
            }

        }
    }
    console.log(arr);
    return arr[1][n - 1];

}

//DP : Top Down Approach O(N^3)
function mcmTopDown(seq, i, j, arr) {

    if (i == j)
        return arr[i][j] = 0;

    if (arr[i][j] >= 0) {
        return arr[i][j];
    }

    let minOps = Number.MAX_SAFE_INTEGER;

    for (let k = i; k < j; k++)
        minOps = Math.min(minOps, mcmTopDown(seq, i, k, arr) + mcmTopDown(seq, k + 1, j, arr) + seq[i - 1] * seq[k] * seq[j]);

    return arr[i][j] = minOps;
}

//Recursive Approach (Exponential)
function mcm(seq, i, j) {
    if (i == j)
        return 0;
    let minOps = Number.MAX_SAFE_INTEGER;
    for (let k = i; k < j; k++) {
        let ops = mcm(seq, i, k) + mcm(seq, k + 1, j) + seq[i - 1] * seq[k] * seq[j];
        minOps = Math.min(minOps, ops);
    }
    return minOps;
}
