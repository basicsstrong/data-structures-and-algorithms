function productSum(list, depth){
    let sum = 0;

    list.forEach(element => {
        if(Array.isArray(element))
        sum += productSum(element, depth + 1); 
        else
        sum += element;
    });

    return sum * depth;
}

const list = [1, 2, [2, 3], 6, [[2, 3], 1], 7];

console.log(productSum(list, 1));