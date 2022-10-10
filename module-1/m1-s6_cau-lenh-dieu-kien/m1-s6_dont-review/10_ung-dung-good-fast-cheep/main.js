let wiperGood = document.getElementById("wiper--good");
let wiperCheap = document.getElementById("wiper--cheap");
let wiperFast = document.getElementById("wiper--fast");
let wiperBarColorOff,
    wiperCircleColorOff,
    wiperBar,
    wiperBarColor,
    wiperBar1,
    wiperBarColor1,
    wiperCircle,
    wiperCircleColor,
    wiperCircle1,
    wiperCircleColor1,
    wiperCircle2;

wiperBarColorOff = "#5f6062";
wiperCircleColorOff = "#cabebe";

function changeStatusWiper() {
    console.log(window.getComputedStyle(wiperCircle).left);
    let isWiperActive = window.getComputedStyle(wiperCircle).left !== "0px";
    let isWiper1Active = window.getComputedStyle(wiperCircle1).left !== "0px";
    let isWiper2Active = window.getComputedStyle(wiperCircle2).left !== "0px";
    if (isWiperActive) {
        wiperCircle.style.left = "0px";
        wiperCircle.style.backgroundColor = wiperCircleColorOff;
        wiperBar.style.backgroundColor = wiperBarColorOff;
    } else if (!isWiper1Active || !isWiper2Active) {
        wiperCircle.style.left = "38px"
        wiperCircle.style.backgroundColor = wiperCircleColor;
        wiperBar.style.backgroundColor = wiperBarColor;
    } else {
        wiperCircle.style.left = "38px"
        wiperCircle.style.backgroundColor = wiperCircleColor;
        wiperBar.style.backgroundColor = wiperBarColor;

        wiperCircle1.style.left = "0px"
        wiperCircle1.style.backgroundColor = wiperCircleColorOff;
        wiperBar1.style.backgroundColor = wiperBarColorOff;
    }
}

wiperGood.addEventListener("click", () => {
    wiperBar = document.getElementById("wiper__bar--good");
    wiperCircle = document.getElementById("wiper__circle--good");
    wiperBarColor = "#7aa26d";
    wiperCircleColor = "#6dbe55";

    wiperBar1 = document.getElementById("wiper__bar--cheap");
    wiperCircle1 = document.getElementById("wiper__circle--cheap");
    wiperBarColor1 = "#6d7da1";
    wiperCircleColor1 = "#5575be";

    wiperCircle2 = document.getElementById("wiper__circle--fast");

    changeStatusWiper();
})

wiperCheap.addEventListener("click", () => {
    wiperBar = document.getElementById("wiper__bar--cheap");
    wiperCircle = document.getElementById("wiper__circle--cheap");
    wiperBarColor = "#6d7da1";
    wiperCircleColor = "#5575be";

    wiperBar1 = document.getElementById("wiper__bar--fast");
    wiperCircle1 = document.getElementById("wiper__circle--fast");
    wiperBarColor1 = "#a26d75";
    wiperCircleColor1 = "#bf5561";

    wiperCircle2 = document.getElementById("wiper__circle--good");

    changeStatusWiper();
})

wiperFast.addEventListener("click", () => {
    wiperBar = document.getElementById("wiper__bar--fast");
    wiperCircle = document.getElementById("wiper__circle--fast");
    wiperBarColor = "#a26d75";
    wiperCircleColor = "#bf5561";

    wiperBar1 = document.getElementById("wiper__bar--good");
    wiperCircle1 = document.getElementById("wiper__circle--good");
    wiperBarColor1 = "#7aa26d";
    wiperCircleColor1 = "#6dbe55";

    wiperCircle2 = document.getElementById("wiper__circle--cheap");

    changeStatusWiper();
})
