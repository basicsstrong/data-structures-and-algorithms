const list = [25, 24, 33, 39, 3, 18, 19, 31, 23, 49, 45, 16, 1, 29, 40, 22, 15, 20, 24, 4, 13, 34]; 
const median = findMedian(list, Math.ceil(list.length/2)+ 1, 0, list.length - 1);
console.log("Median is : ", median);


function findMedian(list, k, low, high){

     const medianIndex = getApproxMedIndex(list, low, high);

     const length = medianIndex - low + 1

     if(length == k){
         return list[medianIndex];
     }
     if(length > k){
         //left
         return findMedian(list, k, low, medianIndex-1);
     }else{
         //right
         return findMedian(list, k-length, medianIndex + 1, high);
     }

}

function getApproxMedIndex(list, low, high){

    const pivot = partitionAndGet(list, low, high);

    //right index for this pivot : Quick Sort
    while(low < high){
        while(list[low] < pivot)
            low++;
        while(list[high] > pivot)
            high--;
        if(list[low] == list[high])
            low++;
        else if(low < high){
            //swap
            let temp = list[low];
            list[low] = list[high];
            list[high] = temp;
        }
    }
    return high;
}

function partitionAndGet(list, low, high){
    
    //Median Of medians
    if(high - low + 1 <= 9 ){
        list.sort((a, b) => a - b);
        return list[Math.ceil(list.length/ 2)];
    }

    //chunking
    let temp = null;
    const mediansArray = [];
    let index = 0;
    while(high >= low){
        temp = [];
        const len = Math.min(5, high - low + 1);

        for(let i = 0; i < len && low <= high; i++){
            temp[i] = list[low];
            low++;
        }

        temp.sort((a, b) => a - b);
        mediansArray[index++] = temp[Math.ceil(temp.length/2)];
    }   

    return partitionAndGet(mediansArray, 0, mediansArray.length - 1);
}


