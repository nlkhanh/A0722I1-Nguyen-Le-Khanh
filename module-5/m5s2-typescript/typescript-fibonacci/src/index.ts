const fibonacciCount = (maxNumber:number, result:number, neg1: number, neg2: number): number => {
  let n = neg1 + neg2;

  if (n > maxNumber) {
    return result;
  }

  result = result += n;

  return fibonacciCount(maxNumber, result, n, neg1);
};


console.log(fibonacciCount(35, 1, 1, 0));