var money = 10000;
function byACar(car) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (money >= 10000) {
                resolve("Can buy " + car);
            }
            else {
                reject(new Error("Do not enough money!"));
            }
        }, 2000);
    });
}
money = 1000;
byACar("Vinfast").then(function (value) { return console.log(value); }).catch(function (err) { return console.error(err); });
