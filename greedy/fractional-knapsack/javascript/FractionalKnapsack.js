const wt = [10, 40, 20, 30] 
const val = [60, 40, 100, 120] 
const capacity = 50

class Item{
    constructor(wt, val, ind) {
        this.wt = wt
        this.val = val
        this.ind = ind
        this.cost = val/wt
    }
}

function getMaxValue(wt, val, capacity) {

    var items = new Array();

    for (let i = 0; i < val.length; i++) {
        let item = new Item(wt[i], val[i], i);
        items.push(item);
    }
    
    items.sort(function(item1, item2){
        return item2.cost - item1.cost
    });   

    console.log("items", items);

    var totalVal = 0;
    for(let index=0; index<items.length; index++){
        var curWt = Math.floor(items[index].wt);
        var curVal = Math.floor(items[index].val);
        if(capacity - curWt >= 0) {
            capacity = capacity - curWt;
            totalVal += curVal;   
        }else {
            fraction = capacity/curWt;
            totalVal += curVal * fraction;
            break;
        }
    }
return totalVal;
}

var maxValue = getMaxValue(wt, val, capacity);
console.log("The maximum profit possible = "+ maxValue)