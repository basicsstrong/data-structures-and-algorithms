const price = [1, 5, 8, 9];
var size = price.length;

console.log("Max obtainable revenue: " + rodCut(price, size));

var arr = new Array(size);
console.log("Max obtainable revenue (top down): " + rodCutTopDown(price, size, arr));

var res = rodCutBottomUp(price);
console.log("Max obtainable revenue (bottom up): " + res);

//DP : Bottom Up Approach O(n^2)
function rodCutBottomUp(price) {
    let r = new Array(price.length + 1);
    r[0] = 0;
    let maxRevenue = Number.MIN_SAFE_INTEGER;

    for (let i = 1; i < r.length; i++) {
        for (let j = 1; j <= i; j++) {
            maxRevenue = Math.max(maxRevenue, price[j - 1] + r[i - j]);
        }
        r[i] = maxRevenue;
    }
    return r[price.length];
}

//DP : Top Down Approach O(n^2)
function rodCutTopDown(price, n, arr) {
    if (n == 0)
        return 0;

    if (arr[n - 1] > 0)
        return dp[n - 1];

    let maxRevenue = Number.MIN_SAFE_INTEGER;

    for (let i = 1; i <= n; i++)
        maxRevenue = Math.max(maxRevenue, price[i - 1] + rodCut(price, n - i));

    return arr[n - 1] = maxRevenue;
}

//Recursive Approach (exponential)
function rodCut(price, n) {

    if (n == 0)
        return 0;

    let maxRevenue = Number.MIN_SAFE_INTEGER;

    for (let i = 1; i <= n; i++)
        maxRevenue = Math.max(maxRevenue, price[i - 1] + rodCut(price, n - i));

    return maxRevenue;
}
