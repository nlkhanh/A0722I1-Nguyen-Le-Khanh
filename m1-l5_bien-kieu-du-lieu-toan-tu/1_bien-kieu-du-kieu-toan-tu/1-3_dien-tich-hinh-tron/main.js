let inputR;
inputR = prompt('Nhập bán kính hình tròn');

let r;
r = parseFloat(inputR);

let s;
s = Math.pow(r, 2) / Math.PI;

alert('Diện tích hình tròn là: ' + s);
