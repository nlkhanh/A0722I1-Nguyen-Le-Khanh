let displayNumber = document.getElementById("calculator__display-number");
let displayOperator = document.getElementById("calculator__display-operator");
let firstDisplayNumber, operator, secondDisplayNumber, result;

// key0
let key0 = document.getElementById("key--0");
function key0Press() {
    let keyNumber = key0.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key0.addEventListener("click", key0Press);

//key1
let key1 = document.getElementById("key--1");
function key1Press() {
    let keyNumber = key1.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key1.addEventListener("click", key1Press);

//key2
let key2 = document.getElementById("key--2");
function key2Press() {
    let keyNumber = key2.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key2.addEventListener("click", key2Press);

//key3
let key3 = document.getElementById("key--3");
function key3Press() {
    let keyNumber = key3.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key3.addEventListener("click", key3Press);

//key4
let key4 = document.getElementById("key--4");
function key4Press() {
    let keyNumber = key4.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key4.addEventListener("click", key4Press);

//key5
let key5 = document.getElementById("key--5");
function key5Press() {
    let keyNumber = key5.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key5.addEventListener("click", key5Press);

//key6
let key6 = document.getElementById("key--6");
function key6Press() {
    let keyNumber = key6.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key6.addEventListener("click", key6Press);

//key7
let key7 = document.getElementById("key--7");
function key7Press() {
    let keyNumber = key7.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key7.addEventListener("click", key7Press);

//key8
let key8 = document.getElementById("key--8");
function key8Press() {
    let keyNumber = key8.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key8.addEventListener("click", key8Press);

//key9
let key9 = document.getElementById("key--9");
function key9Press() {
    let keyNumber = key9.textContent;
    let displayNumberValue = displayNumber.textContent;
    let isDisplayNumberValue0 = displayNumberValue === "0";
    if  (isDisplayNumberValue0 || result) {
        displayNumber.innerText =  keyNumber;
        result = "";
    } else {
        displayNumber.innerText += keyNumber;
    }
}
key9.addEventListener("click", key9Press);

//keyOperator
// keyAdd
let keyAdd = document.getElementById("key--add");
function keyAddPress () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyAdd.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyAdd.addEventListener("click", keyAddPress);

// keySubtract
let keySubtract = document.getElementById("key--subtract");
function keySubtractPress () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keySubtract.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keySubtract.addEventListener("click", keySubtractPress);

// keyMultiply
let keyMultiply = document.getElementById("key--multiply");
function keyMultiplyPress () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyMultiply.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyMultiply.addEventListener("click", keyMultiplyPress);

// keyDivide
let keyDivide = document.getElementById("key--divide");
function keyDividePress () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyDivide.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyDivide.addEventListener("click", keyDividePress);

//keyEqual
let keyEqual = document.getElementById("key--equal");
function keyEqualPress () {
    let keyEqualContent = keyEqual.textContent;
    secondDisplayNumber = displayNumber.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + " " + operator + " " + secondDisplayNumber + " " + keyEqualContent;
    let add = keyAdd.textContent,
        subtract = keySubtract.textContent,
        multiply = keyMultiply.textContent,
        divide = keyDivide.textContent;
    switch (operator) {
        case add:
            result = parseInt(firstDisplayNumber) + parseInt(secondDisplayNumber);
            break;
        case subtract:
            result = parseInt(firstDisplayNumber) - parseInt(secondDisplayNumber);
            break;
        case multiply:
            result = parseInt(firstDisplayNumber) * parseInt(secondDisplayNumber);
            break;
        case divide:
            result = parseInt(firstDisplayNumber) / parseInt(secondDisplayNumber);
    }
    displayNumber.innerText = result;
}
keyEqual.addEventListener("click", keyEqualPress);

//keyClear
let keyClear = document.getElementById("key--clear")
function keyClearPress () {
    displayOperator.innerText ="";
    displayNumber.innerText = "0";
}
keyClear.addEventListener("click", keyClearPress);