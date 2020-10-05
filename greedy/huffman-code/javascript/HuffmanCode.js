class HuffmanNode{
    constructor(freq, data, left, right){
        this.freq = freq;
        this.data = data;
        this.left = left;
        this.right = right;
    }

}

const charBinaryMapping = {};

const str = "ABBCCCCGGGGDEAAAEDBBBDFAGG";
const code = encode(str);
console.log("Final coded string is : ", code);

function encode(str){

    let mapping = {};
    for(let i = 0; i < str.length; i++){
        if(!(str.charAt(i) in mapping)){
            mapping[str.charAt(i)] = 1;
        }else{
            mapping[str.charAt(i)] = mapping[str.charAt(i)] + 1;
        }
    }

     const root = generateTree(mapping);

     console.log(root);

     setBinaryCode(root, "");

     console.log(charBinaryMapping);

     //Generate the binary coded String :
    let s = "";
     for(let i = 0; i < str.length ; i++){
         s += charBinaryMapping[str.charAt(i)]; 
     }

     return s;

}

function setBinaryCode(node, str){
    if(node != null){

        if(node.left == null && node.right == null){
            charBinaryMapping[node.data] = str;
        }

        //left
        str += '0';
        setBinaryCode(node.left, str);
        str = str.slice(0, str.length - 1);
        
        //right
        str += '1';
        setBinaryCode(node.right, str);
        str = str.slice(0, str.length - 1);

    }


}

function generateTree(mapping){

    keySet = Object.keys(mapping);

    const priorityQ = [];

    keySet.forEach(character => {

        let node = new HuffmanNode(mapping[character], character, null, null);
        priorityQ.push(node);
        priorityQ.sort((a, b) => a.freq - b.freq);
        
    });

    while(priorityQ.length > 1 && typeof priorityQ !== 'undefined'){

        const first = priorityQ.shift();
        const second = priorityQ.shift();
        
        let mergeNode = new HuffmanNode((first.freq + second.freq), '-', first, second);

        priorityQ.push(mergeNode);
        priorityQ.sort((a, b) => a.freq - b.freq);

    }

    return priorityQ.shift();

}