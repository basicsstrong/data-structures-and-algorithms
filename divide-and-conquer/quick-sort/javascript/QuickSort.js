const list = [10, 1, 67, 20, 56, 34, 43, 90, 54, 8, 0];

function quickSort(list, lb, ub){

    let index;
    if(lb<ub){
        index = partition(list, lb, ub);

        quickSort(list, lb, index-1);
        quickSort(list, index+1, ub);
    }
}

function partition(list, lb, ub){
    const pivot = list[lb];
    let left = lb;
    let right = ub;

    while(left < right){
        while(list[left] <= pivot && left < list.length-1){
            left++;
        }
        while(list[right] > pivot && right > 0){
            right--;
        }

        //swap
        if(left < right){
            let temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
    //swap right with lb / pivot

    let temp = list[lb];
    list[lb] = list[right];
    list[right] = temp;

    return right;
}

quickSort(list, 0, list.length-1);
console.log(list);