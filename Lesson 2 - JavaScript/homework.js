// Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
function calculateFactorial(number) {
    let factorial = 1;
    for (let i = 1; i <= number; i++) {
        factorial *= i;
    }
    return factorial;

}


reverseString("abc")
// Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
function reverseString(string) {
    let reverse = "";
    for (let index = string.length; index >= 0; index--) {
        reverse += string.s
        
    }

}

//     Ví dụ: reverseString(‘hello’) => olleh

// Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
function translate(country) {
    switch (country) {
        case VN: {
            console.log("Xin chào");
            break;
        }
        case EN: {
            console.log("Hello");
            break;
        }
        case CN: {
            console.log("Nihao");
            break;
        }
        case FR: {
            console.log("Bonjour");
            break;
        }
    }
}


// Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.

//     Ví dụ : subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…”

