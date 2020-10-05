const weight = [7, 4, 4];
const price = [15, 8, 8];
const capacity = 10;
		
var n = weight.length;
		
//bottom Up
console.log(getMaxProfitBottomUp(weight, price, n, capacity));
		
var values = new Array();
		
for(let i = 0; i <= n ; i++) {
    values.push(new Array(capacity+1).fill(-1));
}
console.log(getMaxProfitTopDown(weight, price, n, capacity, values));


//DP : Bottom Up Approach
function getMaxProfitBottomUp(weight, price, n,capacity) {
		
		var values = new Array();
		
		for(let i = 0; i <= n ; i++) {
                values.push(new Array(capacity+1))

			for (let j = 0; j <= capacity; j++) {
				
				if( i== 0 || j == 0) {
					values[i][j] = 0;
				}else {
					let incl = 0, excl = 0;
					
					if(weight[i-1] <= j)
						incl = price[i-1] + values[i-1][j - weight[i-1]];
					
					excl = values[i-1][j];
					
					values[i][j] = Math.max(incl, excl);
				}
			}
		}
		
		return values[n][capacity];
		
	}
	
	//DP : Top Down Approach
	function getMaxProfitTopDown(weight, price, n, capacity, values) { 
		
		if(n == 0 || capacity == 0) {
			values[n][capacity] = 0;
			return 0;
		}
		
		if(values[n-1][capacity-1] != -1)
			return values[n-1][capacity-1];
		
		
		let incl = 0, excl = 0;
		if(weight[n-1] <= capacity) {
			incl = price[n-1] + getMaxProfitTopDown(weight, price, n-1, capacity - weight[n-1], values);
		}
		
		excl = getMaxProfitTopDown(weight, price, n-1, capacity, values);
		
		values[n-1][capacity-1] = Math.max(incl, excl);
		
		return values[n-1][capacity-1];
		
	}
