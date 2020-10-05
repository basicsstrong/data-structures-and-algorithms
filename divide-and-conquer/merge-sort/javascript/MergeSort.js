const list = [11, 6, 3, 9, 14, 66, 2];
const len = list.length;
mergeSort(list, 0, len-1);
console.log(list);


function mergeSort(list, lb, ub){
    if( lb < ub){
        const mid = Math.floor((lb + ub)/ 2);

        mergeSort(list, lb, mid);
        mergeSort(list, mid + 1, ub);
        
        merge(list, lb, mid, ub);
    }        
} 

function merge(list, lb, mid, ub){

    const n1 = mid -lb + 1;
    const n2 = ub - mid;

    const left = [];
    const right = [];

    for(let i = 0; i < n1; i++){
        left[i] = list[lb + i];
    }

    for(let i = 0; i < n2; i++){
        right[i] = list[mid + 1 + i];
    }

    let i = 0, j = 0, k = lb;

    while(i < n1 && j < n2){
        if(left[i] < right[j]){
            list[k] = left[i];
            i++;
        }else{
            list[k] = right[j];
            j++;
        }
        k++;
    }

    while( i < n1){
        list[k] = left[i];
        i++;
        k++;
    }

    while( j < n2){
        list[k] = right[j];
        j++;
        k++;
    }
}