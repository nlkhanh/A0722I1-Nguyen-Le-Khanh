let inputNumber1, inputNumber2, number1, number2, result, operator;
result = 0;

let add, subtract, multiply, divide;

add = document.getElementById('add');
subtract = document.getElementById('subtract');
multiply = document.getElementById('multiply');
divide = document.getElementById('divide');

function inputNumber() {
    inputNumber1 = document.getElementById('number1').value;
    inputNumber2 = document.getElementById('number2').value;

    number1 = parseFloat(inputNumber1);
    number2 = parseFloat(inputNumber2);
}

function outputResult() {
    document.getElementById('operator').innerText = operator + ":";
    document.getElementById('result-value').innerText = result;
}

add.addEventListener('click', addNumber => {
    operator = "Addition";
    inputNumber();
    result = number1 + number2;
    outputResult();
});

subtract.addEventListener('click', subtractNumber => {
    operator = "Subtraction";
    inputNumber();
    result = number1 - number2;
    outputResult();
});

multiply.addEventListener('click', multiNumber => {
    operator = "Multiplication";
    inputNumber();
    result = number1 * number2;
    outputResult();
});

divide.addEventListener('click', divideNumber => {
    operator = "Division";
    inputNumber();
    result = number1 / number2;
    outputResult();
});




