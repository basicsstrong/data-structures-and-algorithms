const str1 = 'Base';
const str2 = 'Basic';

var m = str1.length;
var n = str2.length;

console.log(getlDist(str1, str2, m, n));

var arr = new Array();

for (let i = 0; i < m; i++) {
    arr.push(new Array(n).fill(-1));
}
console.log(arr)
console.log("top down: " + getlDistTopDown(str1, str2, m, n, arr));
console.log("Bottom up: " + getlDistBottomUp(str1, str2));


//DP : Bottom Up Approach
function getlDistBottomUp(str1, str2) {

    var lDist = new Array();
    for (let i = 0; i <= str1.length; i++) {
        lDist.push(new Array(str2.length + 1).fill(-1));
    }

    for (let i = 0; i < str1.length; i++) {
        lDist[0][i] = i;
    }

    for (let i = 0; i < str2.length; i++) {
        lDist[i][0] = i;
    }

    for (let i = 1; i <= str1.length; i++) {
        for (let j = 1; j <= str2.length; j++) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1))
                lDist[i][j] = lDist[i - 1][j - 1];
            else
                lDist[i][j] = Math.min(lDist[i][j - 1], Math.min(lDist[i - 1][j], lDist[i - 1][j - 1])) + 1;
        }
    }

    return lDist[str1.length][str2.length];
}


//DP : Top Down Approach
function getlDistTopDown(str1, str2, m, n, arr) {

    if (m == 0 || n == 0)
        return Math.max(m, n);

    if (arr[m - 1][n - 1] >= 0)
        return arr[m - 1][n - 1];

    let ch1 = 1 + getlDistTopDown(str1, str2, m, n - 1, arr);
    let ch2 = 1 + getlDistTopDown(str1, str2, m - 1, n, arr);

    let k = str1.charAt(m - 1) == str2.charAt(n - 1) ? 0 : 1;

    let ch3 = k + getlDistTopDown(str1, str2, m - 1, n - 1, arr);

    arr[m - 1][n - 1] = Math.min(ch1, Math.min(ch2, ch3));
    return arr[m - 1][n - 1];

}


//Recursive Approach
function getlDist(str1, str2, m, n) {

    if (m == 0 || n == 0)
        return Math.max(m, n);

    let ch1 = 1 + getlDist(str1, str2, m, n - 1);
    let ch2 = 1 + getlDist(str1, str2, m - 1, n);

    let k = str1.charAt(m - 1) == str2.charAt(n - 1) ? 0 : 1;

    let ch3 = k + getlDist(str1, str2, m - 1, n - 1);

    return Math.min(ch1, Math.min(ch2, ch3));

}
