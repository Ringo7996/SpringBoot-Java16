//Bài 1: Kiểm tra 1 giá trị có nằm trong mảng không?

let arr = [1, 2, 3, 4, 5];
let number = 2;
function checkElementExist(arr, number) {
    let exist = false;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == number) {
            exist = true;
            break;
        }
    }
    return exist;
}
console.log("Exist in array: " + checkElementExist(arr, number));


// Bài 2: Truyền vào mảng và giá trị trả về mảng mới lớn hơn giá trị truyền vào.
function getElementGreater(arr, number) {
    let greater = [];
    arr.forEach(element => {
        if (element > number) {
            greater.push(element);
        }
    });

    return greater;
}
console.log("greater in array: " + getElementGreater(arr, number));



//BÀi 3: Tạo mã màu HEx ngẫu nhiên
function getRandomHex() {
    let character = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "A", "B", "C", "D", "E", "F"];
    let hex = "#";
    for (let i = 0; i < 6; i++) {
        hex += character[Math.floor(Math.random() * 16)];
    }
    return hex;
}
console.log(getRandomHex());



//Bài 4: Tạo mã màu RGB ngẫu nhiên.
function getRandomRGB() {
    return rgb = "RGB(" + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + ")";
}
console.log(getRandomRGB());
