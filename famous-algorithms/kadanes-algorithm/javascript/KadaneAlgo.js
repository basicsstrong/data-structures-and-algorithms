
function maxSumSubarray(list) {
    
    let globalMax = list[0];
    let localMax = list[0];
    
    for(let i = 1; i < list.length ; i++) {
        
        localMax = Math.max(localMax + list[i], list[i]);
        
        globalMax = Math.max(globalMax, localMax);
        
    }
    
    return globalMax;
}


var list = [-2, -1, 3, -2, 4, 3, -3, 5 ];

const maxSum = maxSumSubarray(list);

console.log(maxSum);
