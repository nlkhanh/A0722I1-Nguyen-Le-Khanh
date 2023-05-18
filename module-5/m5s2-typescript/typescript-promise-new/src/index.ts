// let money = 10000;
// function byACar(car: any) {
//   return new Promise((resolve, reject) => {
//     setTimeout(() => {
//       if (money >= 10000) {
//         resolve("Can buy " + car);
//       } else {
//         reject(new Error("Do not enough money!"));
//       }
//     }, 2000);
//   })
// }
//
// money = 1000;
// byACar("Vinfast").then(value => console.log(value)).catch(err => console.error(err));

let x = 0;
async function r5 () {
  x += 1;
  console.log(x);
  return 5;
}

(async () => {
  const y = await r5();
  x += y;
  console.log(x);
})();