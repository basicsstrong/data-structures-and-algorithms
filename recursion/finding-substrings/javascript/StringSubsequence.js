function getSubsequence(word){

    if(word == '')
    {
        return '';
    }

    const first = word.charAt(0);

    const rest = getSubsequence(word.substring(1));

    let result = '';

    rest.split(',').forEach(subseq => {

        result += ','+ first + subseq;
        result += ','+ subseq; 

    });

    return result.substring(1);
}

subsequences = getSubsequence('abc');
console.log(subsequences);
