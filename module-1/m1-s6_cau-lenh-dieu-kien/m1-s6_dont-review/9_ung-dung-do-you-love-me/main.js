let answerYes = document.getElementById("button--yes");
let answerNo = document.getElementById("button--no");
let windowWidth = (window.innerWidth) - 80,
    windowHeight = (window.innerHeight) - 40;

function getRandomNum (max) {
    return Math.random() * max;
}

answerYes.addEventListener("click", () => {
    alert("<3")
})

answerNo.addEventListener("mouseover", () => {
    let newPositionHorizontal = getRandomNum(windowWidth) + "px";
    let newPositionVertical = getRandomNum(windowHeight) + "px";
    answerNo.style.left = newPositionHorizontal;
    answerNo.style.top = newPositionVertical;
})