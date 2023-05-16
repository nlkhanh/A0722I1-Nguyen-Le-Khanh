var fibonacciCount = function (maxNumber, result, neg1, neg2) {
    var n = neg1 + neg2;
    if (n > maxNumber) {
        return result;
    }
    result = result += n;
    return fibonacciCount(maxNumber, result, n, neg1);
};
console.log(fibonacciCount(35, 1, 1, 0));
