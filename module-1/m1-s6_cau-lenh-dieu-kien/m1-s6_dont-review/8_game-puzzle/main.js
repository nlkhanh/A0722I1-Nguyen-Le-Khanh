let imgPiece1Wrap = document.getElementById("img-piece__wrap--1");
let imgPiece2Wrap = document.getElementById("img-piece__wrap--2");
let imgPiece3Wrap = document.getElementById("img-piece__wrap--3");
let imgPiece4Wrap = document.getElementById("img-piece__wrap--4");
let imgPiece5Wrap = document.getElementById("img-piece__wrap--5");
let imgPiece1 = document.getElementById("img-piece--1");
let imgPiece2= document.getElementById("img-piece--2");
let imgPiece3= document.getElementById("img-piece--3");
let imgPiece4= document.getElementById("img-piece--4");
let imgPiece5= document.getElementById("img-piece--5");
let imgPiece1Src = imgPiece1.src,
    imgPiece2Src = imgPiece2.src,
    imgPiece3Src = imgPiece3.src,
    imgPiece4Src = imgPiece4.src,
    imgPiece5Src = imgPiece5.src;

function finishedCheck() {
    if (
        imgPiece1Src === imgPiece2Src &&
        imgPiece1Src === imgPiece3Src &&
        imgPiece1Src === imgPiece4Src &&
        imgPiece1Src === imgPiece5Src
    ) {
        imgPiece1Wrap.style.height = "120px";
        imgPiece1Wrap.style.padding = "0px";
        imgPiece1Wrap.style.margin = "0px";
        imgPiece2Wrap.style.height = "120px";
        imgPiece2Wrap.style.padding = "0px";
        imgPiece2Wrap.style.margin = "0px";
        imgPiece3Wrap.style.height = "120px";
        imgPiece3Wrap.style.padding = "0px";
        imgPiece3Wrap.style.margin = "0px";
        imgPiece4Wrap.style.height = "120px";
        imgPiece4Wrap.style.padding = "0px";
        imgPiece4Wrap.style.margin = "0px";
        imgPiece5Wrap.style.height = "120px";
        imgPiece5Wrap.style.padding = "0px";
        imgPiece5Wrap.style.margin = "0px";
    } else {
        imgPiece1Wrap.style.height = "128px";
        imgPiece1Wrap.style.padding = "4px";
        imgPiece1Wrap.style.margin = "0px 0px 4px 0px";
        imgPiece2Wrap.style.height = "128px";
        imgPiece2Wrap.style.padding = "4px";
        imgPiece2Wrap.style.margin = "0px 0px 4px 0px";
        imgPiece3Wrap.style.height = "128px";
        imgPiece3Wrap.style.padding = "4px";
        imgPiece3Wrap.style.margin = "0px 0px 4px 0px";
        imgPiece4Wrap.style.height = "128px";
        imgPiece4Wrap.style.padding = "4px";
        imgPiece4Wrap.style.margin = "0px 0px 4px 0px";
        imgPiece5Wrap.style.height = "128px";
        imgPiece5Wrap.style.padding = "4px";
        imgPiece5Wrap.style.margin = "0px 0px 4px 0px";
    }
}

//piece1
function changeImgPiece1() {
    let imgPieceSrc = imgPiece1.src;
    if (imgPieceSrc.includes("img1.png")) {
        imgPiece1.src = imgPieceSrc.replace("img1.png", "img2.png");
    } else if (imgPieceSrc.includes("img2.png")) {
        imgPiece1.src = imgPieceSrc.replace("img2.png", "img3.png");
    } else {
        imgPiece1.src = imgPieceSrc.replace("img3.png", "img1.png");
    }
    imgPiece1Src = imgPiece1.src;
    finishedCheck();
}
imgPiece1.addEventListener("click", changeImgPiece1);

//piece2
function changeImgPiece2() {
    let imgPieceSrc = imgPiece2.src;
    if (imgPieceSrc.includes("img1.png")) {
        imgPiece2.src = imgPieceSrc.replace("img1.png", "img3.png");
    } else if (imgPieceSrc.includes("img2.png")) {
        imgPiece2.src = imgPieceSrc.replace("img2.png", "img1.png");
    } else {
        imgPiece2.src = imgPieceSrc.replace("img3.png", "img2.png");
    }
    imgPiece2Src = imgPiece2.src;
    finishedCheck();
}
imgPiece2.addEventListener("click", changeImgPiece2);

//piece3
function changeImgPiece3() {
    let imgPieceSrc = imgPiece3.src;
    if (imgPieceSrc.includes("img1.png")) {
        imgPiece3.src = imgPieceSrc.replace("img1.png", "img2.png");
    } else if (imgPieceSrc.includes("img2.png")) {
        imgPiece3.src = imgPieceSrc.replace("img2.png", "img3.png");
    } else {
        imgPiece3.src = imgPieceSrc.replace("img3.png", "img1.png");
    }
    imgPiece3Src = imgPiece3.src;
    finishedCheck();
}
imgPiece3.addEventListener("click", changeImgPiece3);

//piece4
function changeImgPiece4() {
    let imgPieceSrc = imgPiece4.src;
    if (imgPieceSrc.includes("img1.png")) {
        imgPiece4.src = imgPieceSrc.replace("img1.png", "img3.png");
    } else if (imgPieceSrc.includes("img2.png")) {
        imgPiece4.src = imgPieceSrc.replace("img2.png", "img1.png");
    } else {
        imgPiece4.src = imgPieceSrc.replace("img3.png", "img2.png");
    }
    imgPiece4Src = imgPiece4.src;
    finishedCheck();
}
imgPiece4.addEventListener("click", changeImgPiece4);

//piece5
function changeImgPiece5() {
    let imgPieceSrc = imgPiece5.src;
    if (imgPieceSrc.includes("img1.png")) {
        imgPiece5.src = imgPieceSrc.replace("img1.png", "img2.png");
    } else if (imgPieceSrc.includes("img2.png")) {
        imgPiece5.src = imgPieceSrc.replace("img2.png", "img3.png");
    } else {
        imgPiece5.src = imgPieceSrc.replace("img3.png", "img1.png");
    }
    imgPiece5Src = imgPiece5.src;
    finishedCheck();
}
imgPiece5.addEventListener("click", changeImgPiece5);




