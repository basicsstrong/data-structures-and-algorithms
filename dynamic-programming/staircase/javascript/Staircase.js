const steps = 4;
const stepSize = 3; //1,2,3

var arr = new Array(steps + 1);
arr.fill(-1);

var ways = ways(steps, stepSize, arr);
console.log(ways);

//Top-Down
var ways1 = noOfWays(steps, stepSize, arr);
console.log(ways1);

//Bottom-Up
var noOfWays = waysBottomUp(steps, stepSize);
console.log(noOfWays);


//Recursive Approach
function ways(n, k) {
    if (n == 0) {
        return 1;
    }
    if (n < 0)
        return 0;

    let ans = 0;
    for (let j = 1; j <= k; j++)
        ans += ways(n - j, k);
    return ans;
}

//Dynamic Programming : Top Down Approach
function noOfWays(n, k, arr) {

    if (n == 0) {
        arr[n] = 1;
        return 1;
    }

    if (n < 0) {
        return 0;
    }

    if (arr[n] != -1) {
        return arr[n];
    }

    arr[n] = 0;

    for (let i = 1; i <= k; i++) {
        arr[n] = arr[n] + noOfWays(n - i, k, arr);
    }
    return arr[n];
}


//Dynamic Programming : Bottom-Up Approach
function waysBottomUp(n, k) {
    var arr = new Array(n + 1);

    arr[0] = 1;

    for (let i = 1; i <= n; i++) {
        arr[i] = 0;

        for (let j = 1; j <= k; j++) {
            if (i - j >= 0)
                arr[i] = arr[i] + arr[i - j];
        }
    }

    return arr[n];
}