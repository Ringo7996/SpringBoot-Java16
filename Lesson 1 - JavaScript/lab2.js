function rank(mark) {
    if (mark >= 85) {
        console.log("A");
    } else if (70 <= mark && mark <= 85) {
        console.log("B");
    } else if (40 <= mark && mark <= 70) {
        console.log("C");
    } else {
        console.log("D");
    }
}

// Bài 2: Viết function truyền vào 2 số a, b. In ra màn hình số có giá trị lớn hơn
function findGreater(a, b) {
    if (a > b) {
        console.log(a);
    } else if (b > a) {
        console.log(b);
    } else {
        console.log("a = b = " + a);
    }
}


//Bài 3: Viết function nhập vào 1 số. Kiểm tra số đó là số âm, số dương hay là số 0.
function checkNumber(number) {
    if (number > 0) {
        console.log("Số nhập vào là số dương");
    } else if (number < 0) {
        console.log("Số nhập vào là số âm");
    } else {
        console.log("Số nhập vào là 0");
    }
}

// Bài 4: Viết function nhập vào 1 số.Kiểm tra số đó là số chẵn hay số lẻ.
function checkOddOrEven(number) {
    if (number % 2 == 0) {
        console.log("Số nhập vào là số chẵn");
    } else {
        console.log("Số nhập vào là số lẻ");
    }
}

//  Bài 5: Viết function nhập vào 1 số.Kiểm tra số đó có đồng thời chia hết cho 3 và 5 không.
function checkDivisibleNumber(number) {
    if (number % 15 == 0) {
        console.log("Số đã nhập chia hết cho 3 và 5");
    } else {
        console.log("Số đã nhập không chia hết cho 3 và 5");
    }
}


//  Bài 6: Viết function nhập vào 3 số a, b, c.Kiểm tra xem c có bằng a + b không ?
function checkSum(a, b, c) {
    if (a + b == c) {
        console.log("a cộng b bằng c");
    } else {
        console.log("a cộng b không bằng c");
    }
}
