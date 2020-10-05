function towerOfHanoi(n, fromRod, toRod, auxRod){

    if( n == 1){
        console.log("Moving the disk 1 from "+ fromRod + " to the "+ toRod);
    } else{
    towerOfHanoi(n-1, fromRod, auxRod, toRod);
    console.log("Moving the "+n+"th disk from "+ fromRod+ " to the "+ toRod);
    towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }
}

towerOfHanoi(4, 'X', 'Y', 'Z');