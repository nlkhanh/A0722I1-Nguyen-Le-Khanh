function upArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.top = parseInt(element.style.top) - 5 + "px";
}

function downArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.top = parseInt(element.style.top) + 5 + "px";
}

function leftArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.left = parseInt(element.style.left) - 5 + "px";
}

function rightArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.left = parseInt(element.style.left) + 5 + "px";
}


function moveSelection(event) {
    switch (event.key) {
        case "ArrowUp":
            upArrowPressed();
            break;
        case "ArrowDown":
            downArrowPressed();
            break;
        case "ArrowRight":
            rightArrowPressed();
            break;
        case "ArrowLeft":
            leftArrowPressed();
    }
}

function doReady() {
    window.addEventListener("keydown", moveSelection);
}

