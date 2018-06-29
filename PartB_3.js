function permutation(array) {
    function permutate(array, temp) {
        let i, x;

        array.length || result.push(parseInt(temp.join('')));

        for (i = 0; i < array.length; i++) {
            x = array.splice(i, 1)[0];
            permutate(array, temp.concat(x));
            array.splice(i, 0, x);
        }
    }

    const result = [];
    permutate(array, []);
    return result;
}

function smallest(numbers) {
    if (! (numbers instanceof Array)) {
        throw new TypeError("Data must be an Array");
    }

    let combinations = permutation(numbers);
    return Math.min.apply(Math, combinations);
}


// Test...
const inputs = [
    [1, 2, 3],
    [1, 10, 100],
    [100, 97, 23, 1],
    [9041, 376, 5, 10]
];

for (let input of inputs) {
    console.log("Input: " + JSON.stringify(input));
    console.log(`Output: ${smallest(input)}`);
    console.log();
}
