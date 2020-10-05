
	const coins = [ 1, 3, 5, 2 ];
	var len = coins.length;
	var total = 7;
		
	var minNumber = minCoins(coins, len, total);
	var min = minCoinsTopDown(coins, len, total, new Map());
    var minCoins = minCoinsBottomUp(coins, len, total);
    
	console.log(("Minimum coins needed : " + minCoins + " coins"));

	//Recursive Approach
    function minCoins(coins, len, total) {

		if (total == 0)
			return 0;

		let result = Number.MAX_SAFE_INTEGER;
		for (let i = 0; i < len; i++) {
			if (coins[i] <= total) {
				let subResult = minCoins(coins, len, total - coins[i]);
				if (subResult != Number.MAX_SAFE_INTEGER && subResult + 1 < result)
					result = subResult + 1;
			}
		}
		return result;
    }
	
	//DP : Top Down Approach
	function minCoinsTopDown(coins, len, total, map) {

		if (total == 0)
			return 0;
		
		if(map.has(total))
			return map.get(total);

		let result = Number.MAX_SAFE_INTEGER;
		for (let i = 0; i < len; i++) {
			if (coins[i] <= total) {
				let subResult = minCoinsTopDown(coins, len, total - coins[i], map);
				if (subResult != Number.MAX_SAFE_INTEGER && subResult + 1 < result)
					result = subResult + 1;
			}
		}
		
		map.set(total, result);
		return result;
    }
	
	
	//DP : Bottom Up Approach
    function minCoinsBottomUp(coins, len, total) {
		
		var arr = new Array(total + 1);
		arr[0] = 0;
		
		for (let i = 1; i < arr.length; i++) {
			arr[i] = Number.MAX_SAFE_INTEGER;
		}
		
		//denominations
		for (let i = 0; i < len; i++) {
			//total/target Amount
			for (let j = 1; j < arr.length; j++) {
				
				if(coins[i] <= j) {
				
				if(1 + arr[j - coins[i]] < arr[j])
				
				arr[j] = 1 + arr[j - coins[i]];
				}
			}
			
		}
		return arr[total];
	}
