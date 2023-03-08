// Bài 1. Viết function truyền vào 1 chuỗi bất kỳ, hãy sao chép chuỗi đó lên 10 lần.
function tenTimes(string) {
    let ans = "";
    for (let time = 0; time < 10; time++) {
        ans += string;
    }
    return ans;
}



// Bài 2. Viết function truyền vào 1 chuỗi bất kỳ, viết hàm sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang.
function tenTimesWithHyphen(string) {
    let ans = "";
    for (let time = 0; time < 10; time++) {
        if (time == 9) {
            ans += string;
        } else {
            ans += string + "-";
        }

    }
    return ans;
}


// Bài 3. Viết function truyền vào 1 chuỗi bất kỳ và 1 số nguyên dương n > 1, 
// hãy viết hàm có tác dụng sao chép đó chuỗi lên n lần, ngăn cách nhau bởi dấu gạch ngang.
function nTimesWithHyphen(string, number) {
    let ans = "";
    for (let time = 0; time < number; time++) {
        if (time == number - 1) {
            ans += string;
        } else {
            ans += string + "-";
        }

    }
    return ans;
}


// Bài 4. Tính tổng các số chia hết cho 5 từ 0 -> 100
let sumDivisible5 = 0;
for (let i = 0; i <= 100; i = i + 5) {
    sumDivisible5 += i;
}

// Bài 5: Viết hàm tính thể tích hình cầu, với tham số truyền vào là bán kính của hình cầu.
function sphereVolume(radius) {
    return radius * radius * 4 / 3 * 3.14;
}

// Bài 6: Viết hàm truyền vào 2 số nguyên, tính tổng tất cả các số nguyên nằm giữa chúng. 
function sumOfMiddleNumbers(a, b) {
    let sum = 0;
    if (a == b) {
        return 0;
    } else if (a < b) {
        for (let i = a + 1; i < b; i++) {
            sum += i;
        }
        return sum;
    } else {
        for (let i = b + 1; i < a; i++) {
            sum += i;
            return sum;
        }
    }
}


// Bài 7: Cho 1 số, kiểm tra xem số đó có phải là số nguyên tố hay không, kết quả trả về true hoặc false.
function checkPrimaryNumber(number) {
    for (let i = 2; i < number; i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}

// Bài 8: Cho 1 số nguyên dương bất kỳ. Tính tổng tất cả các số nguyên tố mà nhỏ hơn hoặc bằng tham số truyền vào.
function sumPrimaryNumbers(number) {
    let sum = 0;
    for (let i = 2; i <= number; i++) {
        let isPrimaryNumber = true;
        for (let j = 2; j < i; j++) {
            if (i % j == 0) {
                isPrimaryNumber = false;
                break;
            }
        }

        if (isPrimaryNumber == true) {
            sum += i;
        }
    }
    return sum;
}

// Bài 9: Cho 1 số nguyên dương, viết hàm tính tổng tất cả các ước số của số đó.
function sumDivisor(number) {
    let sum = 0;
    for (let i = 1; i <= number; i++) {
        if (number % i == 0) {
            sum += i;
        }
    }
    return sum;
}