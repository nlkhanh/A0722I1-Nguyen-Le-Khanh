function getResult() {
    let month, result;
    month = parseFloat(document.getElementById("month_input").value);
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            result = "Tháng " + month + " có 31 ngày";
            break;
        case 2:
            result = "Tháng " + month + " có 28 hoặc 29 ngày";
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            result = "Tháng " + month + " có 30 ngày";
            break;
        default:
            result = "Bạn đã nhập tháng sai";
    }
    document.getElementById("result").innerText = result;
}

let daysCalc = document.getElementById("days-calc_button");
daysCalc.addEventListener("click", getResult);



