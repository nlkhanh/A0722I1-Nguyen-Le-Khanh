let displayNumber = document.getElementById("calculator__display-number");
let displayOperator = document.getElementById("calculator__display-operator");
let firstDisplayNumber, operator, secondDisplayNumber, result;

// key0
let key0 = document.getElementById("key--0");
function pressKey0() {
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
key0.addEventListener("click", pressKey0);

//key1
let key1 = document.getElementById("key--1");
function pressKey1() {
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
key1.addEventListener("click", pressKey1);

//key2
let key2 = document.getElementById("key--2");
function pressKey2() {
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
key2.addEventListener("click", pressKey2);

//key3
let key3 = document.getElementById("key--3");
function pressKey3() {
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
key3.addEventListener("click", pressKey3);

//key4
let key4 = document.getElementById("key--4");
function pressKey4() {
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
key4.addEventListener("click", pressKey4);

//key5
let key5 = document.getElementById("key--5");
function pressKey5() {
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
key5.addEventListener("click", pressKey5);

//key6
let key6 = document.getElementById("key--6");
function pressKey6() {
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
key6.addEventListener("click", pressKey6);

//key7
let key7 = document.getElementById("key--7");
function pressKey7() {
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
key7.addEventListener("click", pressKey7);

//key8
let key8 = document.getElementById("key--8");
function pressKey8() {
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
key8.addEventListener("click", pressKey8);

//key9
let key9 = document.getElementById("key--9");
function pressKey9() {
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
key9.addEventListener("click", pressKey9);

//keyOperator
// keyAdd
let keyAdd = document.getElementById("key--add");
function pressKeyAdd () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyAdd.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyAdd.addEventListener("click", pressKeyAdd);

// keySubtract
let keySubtract = document.getElementById("key--subtract");
function pressKeySubtract () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keySubtract.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keySubtract.addEventListener("click", pressKeySubtract);

// keyMultiply
let keyMultiply = document.getElementById("key--multiply");
function pressKeyMultiply () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyMultiply.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyMultiply.addEventListener("click", pressKeyMultiply);

// keyDivide
let keyDivide = document.getElementById("key--divide");
function pressKeyDivide () {
    firstDisplayNumber = displayNumber.textContent;
    operator = keyDivide.textContent;
    displayOperator.innerText = firstDisplayNumber + " " + operator;
    displayNumber.innerText = "0";
}
keyDivide.addEventListener("click", pressKeyDivide);

//keyEqual
let keyEqual = document.getElementById("key--equal");
function pressKeyEqual () {
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
keyEqual.addEventListener("click", pressKeyEqual);

//keyClear
let keyClear = document.getElementById("key--clear")
function pressKeyClear () {
    displayOperator.innerText ="";
    displayNumber.innerText = "0";
}
keyClear.addEventListener("click", pressKeyClear);