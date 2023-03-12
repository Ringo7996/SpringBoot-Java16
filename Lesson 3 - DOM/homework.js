//Câu 1. Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu
// Đặt màu văn bản thành #777
// Đặt kích thước phông chữ thành 2rem
// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.

let text = document.getElementById("text");
text.style.color = "#777";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript";


//Câu 2. Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)
let li = document.querySelectorAll("ul:not(#list) > li");
li.forEach(element => {
    element.style.color = "blue";
});



//Câu 3. Cho mã HTML có nội dung như sau (tạo thẻ ul-li bằng html):Sử dụng javascript để thực hiện những công việc sau
// Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
let ul = document.getElementById("list");
for (let i = 8; i <= 10; i++) {
    let newItem = document.createElement("li");
    newItem.innerText = "Item " + i;
    ul.insertAdjacentElement("beforeend", newItem);
}

// Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
let li1 = document.querySelector("#list > li:first-child");
li1.style.color = "red";

// Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
let li3 = document.querySelector("#list > li:nth-child(3)");
li3.style.backgroundColor = "blue";

// Remove thẻ <li> 4
let li4 = document.querySelector("#list >li:nth-child(4)");
ul.removeChild(li4);

// Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
let replaceItem = document.createElement("li");
replaceItem.innerText = "replace Item";
li3.insertAdjacentElement("afterend", replaceItem);