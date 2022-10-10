let imgObj = null;

function init() {
    imgObj = document.getElementById("my-image");
    imgObj.style.position = "relative";
    imgObj.style.left = "0px";
}

function moveRight() {
    imgObj.style.left = parseInt(imgObj.style.left) + 10 + "px";
}

window.onload = init;
