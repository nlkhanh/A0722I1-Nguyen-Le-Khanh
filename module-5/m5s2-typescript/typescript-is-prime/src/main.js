function isPrime(num) {
    var isPrime = true;
    if (num < 2) {
        isPrime = false;
    }
    else if (num > 2) {
        for (var i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}
var arr = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
var sum = 0;
for (var _i = 0, arr_1 = arr; _i < arr_1.length; _i++) {
    var number = arr_1[_i];
    if (isPrime(number)) {
        sum += number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);
