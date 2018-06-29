<?php

/**
 * Determine whether the given number is a fibonacci number.
 *
 * @param  int  $number
 * @return bool
 */
function is_fibonacci($number)
{
    $x1 = 5 * ((int) pow($number, 2)) + 4;
    $x2 = 5 * ((int) pow($number, 2)) - 4;

    $x1SqrRoot = (int) sqrt($x1);
    $x2SqrRoot = (int) sqrt($x2);

    // Source: https://en.wikipedia.org/wiki/Fibonacci_number#Recognizing_Fibonacci_numbers
    return (($x1SqrRoot * $x1SqrRoot) == $x1) || (($x2SqrRoot * $x2SqrRoot) == $x2);
}


// Test...
$numbers = [2, 1000000, 7540113804746346429];

foreach ($numbers as $number) {
    echo "Input: {$number}".PHP_EOL;
    echo "Output: ";
    echo is_fibonacci($number) ? "true" : "false";
    echo PHP_EOL.PHP_EOL;
}
