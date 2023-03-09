//Bài 1: Viết function tìm số lớn nhất trong mảng

let arr = [4, 2, 5, 6, 2, 7];
function findMax(arr) {
    let max = arr[0];

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

console.log("max=" + findMax(arr));
console.log("min=" + findMin(arr));


//Bài 2: Viết function tìm số nhỏ nhất trong mảng
function findMin(arr) {
    let min = arr[0];

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    return min;
}

//Bài 3: Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
function div2(arr) {
    let ans = [];
    for (let i = 0; i < arr.length; i++) {
        ans[i] = arr[i] % 2;
    }
    return ans;
}
console.log("div2=" + div2(arr));


//Bài 4: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần (Sử dụng array để làm)
function x10(string) {
    let arr = [];
    for (let i = 0; i < 10; i++) {
        arr[i] = string;
    }

    let ans = "";
    for (let i = 0; i < arr.length; i++) {
        ans += arr[i];
    }
    return ans;
}
console.log(x10("ab"));


// Bài 5: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang (Sử dụng array để làm)
function x10withHyphen(string) {
    let arr2 = [];
    for (let i = 0; i < 10; i++) {
        arr2[i] = string;
    }

    let ans2 = "";
    for (let i = 0; i < arr2.length; i++) {
        if (i == 9) {
            ans2 += arr2[i];
        } else {
            ans2 += arr2[i] + "-";
        }
    }
    return ans2;
}
console.log(x10withHyphen("ab"));
