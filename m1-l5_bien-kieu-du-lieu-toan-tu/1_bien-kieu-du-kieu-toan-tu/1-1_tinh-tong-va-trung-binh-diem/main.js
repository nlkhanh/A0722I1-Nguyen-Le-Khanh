let inputPhysScore;
let inputChemScore;
let inputBioScore;

inputPhysScore = prompt('Nhập điểm Vật lý');
inputChemScore = prompt('Nhập điểm Hóa học');
inputBioScore = prompt('Nhập điểm Sinh học');

let physScore = parseFloat(inputPhysScore);
let chemScore = parseFloat(inputChemScore);
let bioScore = parseFloat(inputBioScore);

let sumScore = (physScore + chemScore + bioScore);
let averageScore = sumScore / 3;

alert('Tổng số điểm: ' + sumScore);
alert('Điểm trung bình: ' + averageScore);
